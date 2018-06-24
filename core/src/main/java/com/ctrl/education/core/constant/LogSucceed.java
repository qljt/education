package com.ctrl.education.core.constant;

/**
 * com.ctrl.education.core.constant
 *
 * @name LogSucceed
 * @description
 * @date 2018-06-23 18:18
 */
public enum LogSucceed {
    SUCCESS("成功"),
    FAIL("失败");

    String message;

    LogSucceed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
