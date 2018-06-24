package com.ctrl.education.core.log.factory;

import com.ctrl.education.core.constant.LogSucceed;
import com.ctrl.education.core.constant.LogType;
import com.ctrl.education.core.db.Db;
import com.ctrl.education.dao.SysLogMapper;
import com.ctrl.education.dao.SysLoginLogMapper;
import com.ctrl.education.model.SysLog;
import com.ctrl.education.model.SysLoginLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * com.ctrl.education.core.factory
 *
 * @name LogTaskFactory
 * @description
 * @date 2018-06-23 18:19
 */
public class LogTaskFactory {
    private static Logger logger = LoggerFactory.getLogger(com.ctrl.education.core.log.factory.LogManager.class);
    private static SysLoginLogMapper loginLogMapper = Db.getMapper(SysLoginLogMapper.class);
    private static SysLogMapper operationLogMapper = Db.getMapper(SysLogMapper.class);

    public static TimerTask loginLog(final String userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    SysLoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final String username, final String msg, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                SysLoginLog loginLog = LogFactory.createLoginLog(
                        LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg, ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录失败异常!", e);
                }
            }
        };
    }

  public static TimerTask exitLog(final String userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                SysLoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null,ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建退出日志异常!", e);
                }
            }
        };
    }

     /* public static TimerTask bussinessLog(final Integer userId, final String bussinessName, final String clazzName, final String methodName, final String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                SysLog operationLog = LogFactory.createOperationLog(
                        LogType.BUSSINESS, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask exceptionLog(final Integer userId, final Exception exception) {
        return new TimerTask() {
            @Override
            public void run() {
                SysLog operationLog = LogFactory.createOperationLog(
                        LogType.EXCEPTION, userId, "", null, null, msg, LogSucceed.FAIL);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建异常日志异常!", e);
                }
            }
        };
    }*/
}
