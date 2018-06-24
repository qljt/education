package com.ctrl.education.core.constant;

/**
 * 系统级静态变量
 * @author liyang
 * @pkname com.aloha.app.core.constant
 * @name SysConstant
 * @description
 * @date 2018-04-20 11:40
 */
public class SysConstant {
    /**
     * 日志类型
     */
    public enum LogType {

        /**
         * 登录登出日志
         */
        LOGIN(1),

        /**
         * 访问日志
         */
        ACCESS(2),

        /**
         * 操作日志
         */
        OPERATION(3),

        /**
         * 异常日志
         */
        ERROR(4),

        /**
         * 授权日志
         */
        AUTHORIZATION(5);

        private int value;

        LogType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

    }

    /**
     * 通用变量，表示可用、禁用、显示、隐藏
     */
    public enum StatusType {

        /**
         * 禁用，隐藏
         */
        DISABLE(0),

        /**
         * 可用，显示
         */
        ENABLE(1),

        /**
         * 显示
         */
        SHOW(1),

        /**
         * 隐藏
         */
        HIDDEN(0),
        /**
         * 成功
         */
        SUCCESS(1),
        /**
         * 失败
         */
        FAILE(2);
        private int value;

        StatusType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
}
