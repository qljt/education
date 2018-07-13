package com.ctrl.education.core.utils;



import com.ctrl.education.core.constant.SystemConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * com.aloha.app.core.utils
 *
 * @author zgl
 * @name Result
 * @description 返回结果工具类
 * @date 2018-02-28 10:44
 */
public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", SystemConstant.SUCCESS);
        put("msg", SystemConstant.QUERY_SUCCESS);
    }

    public static Result error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
