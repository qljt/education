package com.ctrl.education.core.utils;

/**
 * com.ctrl.education.core.utils
 *
 * @author liyang
 * @name ToolUtils
 * @description
 * @date 2018-06-04 下午9:44
 */
public class ToolUtils {
    /**
     * 生成随机汉字
     * @return
     */
    public static char getRandomChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }
}
