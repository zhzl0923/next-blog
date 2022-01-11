package com.example.nextblog.config;

import com.example.nextblog.model.vo.Result;
import com.example.nextblog.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public Result<Object> validatedBindException(BindException e) {
        log.error(e.getMessage(), e);
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = e.getFieldError();
        String message = "[" + e.getAllErrors().get(0).getDefaultMessage() + "]";
        return ResponseUtil.fail(message);
    }

}
