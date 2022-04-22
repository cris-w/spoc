package com.wsh.spoc.exception;

import com.wsh.spoc.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 *
 * @author wjh
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    /**
     * 自定义异常捕获
     *
     * @param e e
     * @return error
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = MyException.class)
    public R<Void> handler(MyException e) {
        log.error("自定义异常-----------------{}", e.getMsg());
        return R.error(e.getCode(), e.getMsg());
    }

    /**
     * 运行时异常捕获
     *
     * @param e e
     * @return error 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public R<Void> handler(RuntimeException e) {
        log.error("运行时异常-----------------{}", e.getMessage());
        return R.error(400, e.getMessage());
    }
}
