package com.mall.core.domain.utils;

import lombok.Data;

/**
 * Created by Meddkim on 2017/11/18.
 */

@Data
public class BaseResponse {
    private boolean success;
    private String resultCode;
    private String resultMessage;
    private Object resultContent;

    /**
     * 错误信息
     * @param resultCode
     * @param resultMessage
     */
    private BaseResponse(boolean success,String resultCode,String resultMessage,Object resultContent){
        this.success = success;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resultContent = resultContent;
    }

    private BaseResponse(){}

    public static BaseResponse successResp(Object resultContent){
        return new BaseResponse(true,"SC_200","success",resultContent);
    }

    public static BaseResponse successResp(String resultMessage){
        return new BaseResponse(true,"SC_200",resultMessage,null);
    }

    public static BaseResponse successResp(String resultMessage,Object resultContent){
        return new BaseResponse(true,"SC_200",resultMessage,resultContent);
    }
    public static BaseResponse failResp(String resultCode,String resultMessage){
        return new BaseResponse(false,resultCode,resultMessage,null);
    }

}