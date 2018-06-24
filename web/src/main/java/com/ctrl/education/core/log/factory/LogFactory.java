package com.ctrl.education.core.log.factory;

import com.ctrl.education.core.constant.LogSucceed;
import com.ctrl.education.core.constant.LogType;
import com.ctrl.education.core.constant.SysConstant;
import com.ctrl.education.model.SysLoginLog;

import java.util.Date;

/**
 * com.ctrl.education.core.factory
 *
 * @name LogFactory
 * @description
 * @date 2018-06-23 16:34
 */
public class LogFactory {
    /**
     * 创建操作日志
     */
   /* public static OperationLog createOperationLog(LogType logType, Integer userId, String bussinessName, String clazzName, String methodName, String msg, LogSucceed succeed) {
        OperationLog operationLog = new OperationLog();
        operationLog.setLogtype(logType.getMessage());
        operationLog.setLogname(bussinessName);
        operationLog.setUserid(userId);
        operationLog.setClassname(clazzName);
        operationLog.setMethod(methodName);
        operationLog.setCreatetime(new Date());
        operationLog.setSucceed(succeed.getMessage());
        operationLog.setMessage(msg);
        return operationLog;
    }*/

    /**
     * 创建登录日志
     */
    public static SysLoginLog createLoginLog(LogType logType, String userId, String msg, String ip) {
        SysLoginLog loginLog = new SysLoginLog();
        loginLog.setLogname(logType.getMessage());
        loginLog.setUserid(userId);
        loginLog.setCreatetime(new Date());
        loginLog.setSucceed(LogSucceed.SUCCESS.getMessage());
        loginLog.setIp(ip);
        loginLog.setMessage(msg);
        return loginLog;
    }
}
