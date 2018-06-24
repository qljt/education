package com.ctrl.education.core.constant;

/**
 * com.ctrl.education.core.constant
 *
 * @name LogType
 * @description
 * @date 2018-06-23 18:15
 */
public enum LogType {
    LOGIN("登录日志"),
    LOGIN_FAIL("登录失败日志"),
    EXIT("退出日志"),
    EXCEPTION("异常日志"),
    BUSSINESS("业务日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
