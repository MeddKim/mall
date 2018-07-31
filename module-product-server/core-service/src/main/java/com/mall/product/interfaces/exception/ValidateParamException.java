package com.mall.product.interfaces.exception;

import org.springframework.validation.BindingResult;

public class ValidateParamException extends RuntimeException{

    private String message;

    public ValidateParamException(BindingResult bindingResult){
        this.message = bindingResult.getFieldError().getDefaultMessage();
    }
    public ValidateParamException(String msg){
        this.message = msg;
    }

    public String getErrorMessage(){
        return this.message;
    }

}
