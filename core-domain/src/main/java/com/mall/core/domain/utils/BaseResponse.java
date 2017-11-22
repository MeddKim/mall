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

    /**
     * 正确返回，默认SC_200
     */
    public static BaseResponse successResp(HttpCode HttpCode){
        return new BaseResponse(true,HttpCode.SUCCESS.getResultCode(),HttpCode.SUCCESS.getResultMessage(),null);
    }

    /**
     * 正确返回，使用HttpCode
     */
    public static BaseResponse successResp(HttpCode httpCode,Object resultContent){
        return new BaseResponse(true,httpCode.getResultCode(),httpCode.getResultMessage(),resultContent);
    }

    /**
     * 正确返回，改写resultMessage
     */
    public static BaseResponse successResp(HttpCode httpCode,String resultMessage,Object resultContent){
        return new BaseResponse(true,httpCode.getResultCode(),resultMessage ,resultContent);
    }

    /**
     * 错误返回，使用HttpCode
     */
    public static BaseResponse failResp(HttpCode httpCode){
        return new BaseResponse(false,httpCode.getResultCode(),httpCode.getResultMessage(),null);
    }

    /**
     * 错误返回，改写resultMessage
     */
    public static BaseResponse failResp(HttpCode httpCode,String resultMessage){
        return new BaseResponse(false,httpCode.getResultCode(),resultMessage,null);
    }

}