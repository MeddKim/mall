package com.mall.product.interfaces.controller;

import com.mall.core.domain.utils.BaseResponse;
import com.mall.product.interfaces.exception.ValidateParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionRestController {

    @ExceptionHandler(ValidateParamException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Object validateParamsException(ValidateParamException e){
        log.info("");
        return BaseResponse.failResp("SC_40101",e.getErrorMessage());
    }

}
