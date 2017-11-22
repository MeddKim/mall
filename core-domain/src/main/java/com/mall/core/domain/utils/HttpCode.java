package com.mall.core.domain.utils;

public enum HttpCode {

    //200-20001
    SUCCESS("SC_200","操作成功！"),
    CREATEDSUCCESS("SC_201","创建成功"),

    //Bad Request
    BADREQUEST("SC_400","请求异常"),
    ILLEGALPARAMETER("SC_40001","参数异常"),
    //
    INTERNALERROR("SC_50000","服务器错误，请联系开发人员");


    private String resultCode;
    private String resultMessage;


    HttpCode(String resultCode, String resultMessage){
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultCode(){
        return this.resultCode;
    }
    public String getResultMessage(){
        return this.resultMessage;
    }
}
