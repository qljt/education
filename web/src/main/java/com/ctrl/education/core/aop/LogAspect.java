package com.ctrl.education.core.aop;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SysConstant;
import com.ctrl.education.core.log.factory.LogManager;
import com.ctrl.education.core.log.factory.LogTaskFactory;
import com.ctrl.education.core.support.HttpKit;
import com.ctrl.education.core.utils.IpUtils;
import com.ctrl.education.core.utils.JSONUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysLog;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * com.ctrl.education.core.aop
 *
 * @name LogAspect
 * @description
 * @date 2018-06-24 17:14
 */
@Aspect
@Component
public class LogAspect {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "@annotation(com.ctrl.education.core.annotation.BussinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = joinPoint.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        BussinessLog sysLogAnnotation = method.getAnnotation(BussinessLog.class);
        if (sysLogAnnotation != null) {
            //注解上的描述
            sysLog.setOperation(sysLogAnnotation.value());
            String type = sysLogAnnotation.type();
            if (StringUtils.isNotEmpty(type)) {
                sysLog.setType(SysConstant.LogType.valueOf(type).getValue());
            } else {
                sysLog.setType(SysConstant.LogType.OPERATION.getValue());
            }
        }
        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = JSONUtils.beanToJson(args[0]);
            sysLog.setParams(params);
        } catch (Exception e) {

        }

        //设置IP地址
//        sysLog.setIp(IpUtils.getIpAddr());

        //用户名
        SysUser sysUser =ShiroKit.getUser();
        sysLog.setUserId(sysUser.getId());
        sysLog.setUsername(sysUser.getUsername());

        sysLog.setIp(IpUtils.getIpAddr());

        //操作执行状态
        if (result instanceof Result) {
            Result r = (Result) result;
            int code = (int) r.get("code");
            if (code == 0) {
                //操作成功
                sysLog.setResult(SysConstant.StatusType.SUCCESS.getValue());

                //响应时间：ms
                sysLog.setRemark("响应时间：" + time + "ms");
            } else {
                sysLog.setResult(SysConstant.StatusType.FAILE.getValue());
                sysLog.setRemark(String.valueOf(r.get("msg")));
            }
        }
        LogManager.me().executeLog(LogTaskFactory.bussinessLog(sysLog));
    }
}
