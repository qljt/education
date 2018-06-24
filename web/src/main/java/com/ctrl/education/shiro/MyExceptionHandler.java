package com.ctrl.education.shiro;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.ctrl.education.core.utils.Result;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * com.ctrl.education.shiro.config
 *
 * @author liyang
 * @name MyExceptionHandler
 * @description
 * @date 2018-06-05 上午12:09
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        if (ex instanceof UnauthenticatedException) {
            Result.ok().put("msg", "token错误");
        } else if (ex instanceof UnauthorizedException) {
            Result.ok().put("msg", "用户无权限");
        } else {
            Result.ok().put("msg",  ex.getMessage());
        }

        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }
}
