package com.ctrl.education.core.constant;

/**
 *
 * @name SystemConstant
 * @description
 */
public class SystemConstant {

    /**
     * 后台接口请求成功返回code值
     */
    public static final int SUCCESS = 10000;

    /**
     * 后台错误异常返回code值
     */
    public static final int ERROR_CODE = 500;

    /**
     * 不对匹配该值的访问路径拦截（正则）
     */
    public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(checkAuth)|(front)|(frontInformaction)|(checkSysUserOnline)).*";

    // 定义后台公用的返回信息值

    public static final String SERVER_EXCEPTION_MSG="服务器异常";
    public static final String QUERY_EXIST= "已经存在";
    public static final String HAS_CHILDREN="存在子项目，不允许删除";
    public static final String ADD_SUCCESS="添加成功";
    public static final String ADD_FAILURE="添加失败";
    public static final String COLLECT_SUCCESS="收藏成功";
    public static final String COLLECT_FAILURE="收藏失败";
    public static final String DELETE_SUCCESS="删除成功";
    public static final String DELETE_FAILURE="删除失败";
    public static final String UPDATE_SUCCESS="修改成功";
    public static final String UPDATE_FAILURE="修改失败";
    public static final String DISABLE_SUCCESS="禁用成功";
    public static final String DISABLE_FAILURE="禁用失败";
    public static final String ENABLE_SUCCESS="启用成功";
    public static final String ENABLE_FAILURE="启用失败";
    public static final String QUERY_SUCCESS="查询成功";
    public static final String QUERY_FAILURE="查询失败";
    public static final String SEND_SUCCESS="发布成功";
    public static final String SEND_FAILURE="发布失败";
    public static final String CODE_OUT_OF_TIME="验证码超时";
    public static final String UPLOAD_IMG_SUCCESS_MSG="上传成功!";
    public static final String UPLOAD_IMG_ERROR_MSG="上传失败！";
    public static final String UPLOADANDVALIDATEDSUCCESS="上传成功，数据验证成功";
    public static final String UPLOADANDVALIDATEDERROR = "上传成功，数据验证失败";
    public static final String EXPORT_EXCELDATA_SUCCESS="导入成功";
    public static final String EXPORT_EXCEL_DATA_FAILURE="导入成功";
    public static final String ALLOT_AUTH_SUCCESS_MSG="设置权限成功!";
    public static final String ALLOT_AUTH_FAILE_MSG="设置权限失败！";
    public static final String ALLOT_ROLE_SUCCESS_MSG="分配角色成功!";
    public static final String ALLOT_ROLE_FAILE_MSG="分配角色失败！";
    public static final String CATEGORY_NAME_REPEAT_MSG="分类名称重复";
    public static final String LOGIN_OUT_MSG="注销成功";
    public static final String LOGIN_SUCESS="登录成功";
    public static final String EMBER_NONE="会员账号不存在";
    public static final String PASSWORD_INCORRECT="密码不正确";
    public static final String REGISTER_SUCCESS="注册成功";
    public static final String REGISTER_FAIL="注册失败";
    public static final String RESULT_KEY="result";
    public static final String USER_NAME_IS_EXIST = "该账号已经存在";
    public static final String PARAM_ERROR = "参数错误";
    public static final String PARAM_NULL_ERROR = "缺少必要的参数";
    public static final String EXSIT_CHILD_MENU="存在子集，不允许删除";
    public static final String RESET_PWD_SUCCESS="重置密码成功";
    public static final String RESET_PWD_FAILURE="重置密码失败";
    public static final String USER_ADMIN="admin";//账号为admin不允许删除

    /**
     * 数据权限过滤
     */
    public static final String SQL_FILTER = "sql_filter";

}
