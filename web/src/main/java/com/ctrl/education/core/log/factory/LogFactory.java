package com.ctrl.education.core.log.factory;

import com.ctrl.education.core.constant.LogSucceed;
import com.ctrl.education.core.constant.LogType;
import com.ctrl.education.model.SysLog;
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
    public static SysLog createOperationLog(SysLog sysLog) {
        return sysLog;
    }

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
