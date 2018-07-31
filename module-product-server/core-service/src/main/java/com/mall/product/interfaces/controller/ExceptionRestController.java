package com.mall.product.interfaces.controller;

import com.mall.core.domain.utils.BaseResponse;
import com.mall.core.domain.utils.HttpCode;
import com.mall.product.interfaces.exception.ValidateParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;

@Slf4j
@RestControllerAdvice
public class ExceptionRestController {

    /**
     * 管理基本异常（来源于：ResponseEntityExceptionHandler）
     * @return
     */
    @ExceptionHandler({
            org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            MissingServletRequestPartException.class,
            BindException.class,
            NoHandlerFoundException.class,
            AsyncRequestTimeoutException.class,
            SQLException.class
    })
    @ResponseStatus(value = HttpStatus.OK)
    public Object overrideExceptionHandler(Exception e){
        log.error("---------------内部异常打印 start--------------");
        log.error(e.getMessage());
        log.error("---------------内部异常打印 end----------------");
        return BaseResponse.failResp(HttpCode.INTERNALERROR);
    }

    @ExceptionHandler(ValidateParamException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Object validateParamsException(ValidateParamException e){
        log.info("");
        return BaseResponse.failResp(HttpCode.BADREQUEST,e.getErrorMessage());
    }

}
