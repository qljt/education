package com.ctrl.education.core.exception;


import com.ctrl.education.core.constant.SystemConstant;

/**
 * com.aloha.app.core.exception
 *
 * @author zgl
 * @name AlohaException
 * @description
 * @date 2018-02-28 10:19
 */
public class AlohaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = SystemConstant.ERROR_CODE;

    public AlohaException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AlohaException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public AlohaException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public AlohaException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
