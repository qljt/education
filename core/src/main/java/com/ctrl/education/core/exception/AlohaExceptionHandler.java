package com.ctrl.education.core.exception;

import com.ctrl.education.core.utils.Result;
import org.apache.xmlbeans.impl.piccolo.util.DuplicateKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * com.aloha.app.authority.exception
 *
 * @author zgl
 * @name AlohaExceptionHandler
 * @description 异常处理器
 * @date 2018-02-28 10:46
 */
@RestControllerAdvice
public class AlohaExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(AlohaException.class)
    public Result handleRRException(AlohaException alohaException) {
        Result result = new Result();
        result.put("code", alohaException.getCode());
        result.put("msg", alohaException.getMessage());

        return result;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException duplicateKeyException) {
        logger.error(duplicateKeyException.getMessage(), duplicateKeyException);
        return Result.error("数据库中已存在该记录");
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception exception) {
        logger.error(exception.getMessage(), exception);
        return Result.error();
    }
}
