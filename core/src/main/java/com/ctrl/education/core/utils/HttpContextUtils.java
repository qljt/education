package com.ctrl.education.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * http上下文
 * @author liyang
 * @pkname com.aloha.app.core.utils
 * @name HttpContextUtils
 * @description
 * @date 2018-04-20 11:38
 */
public class HttpContextUtils {
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
