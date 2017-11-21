package com.mall.product.interfaces.exception;

import org.springframework.validation.BindingResult;

public class ValidateParamException extends RuntimeException{

    private BindingResult bindingResult;

    public ValidateParamException(BindingResult bindingResult){
        this.bindingResult = bindingResult;
    }

    public String getErrorMessage(){
        return this.bindingResult.getFieldError().getDefaultMessage();
    }
}
