package com.ctrl.education.core.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * com.ctrl.education.core.support
 *
 * @author liyang
 * @name WafRequestWrapper
 * @description
 * @date 2018-06-10 下午7:23
 */
public class WafRequestWrapper extends HttpServletRequestWrapper {

    private boolean filterXSS = true;

    private boolean filterSQL = true;


    public WafRequestWrapper(HttpServletRequest request, boolean filterXSS, boolean filterSQL) {
        super(request);
        this.filterXSS = filterXSS;
        this.filterSQL = filterSQL;
    }


    public WafRequestWrapper(HttpServletRequest request) {
        this(request, true, true);
    }
}
