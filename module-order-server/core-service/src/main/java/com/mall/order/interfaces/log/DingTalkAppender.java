package com.mall.order.interfaces.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Map;

public class DingTalkAppender extends AppenderBase<ILoggingEvent> {

    //钉钉url
    private String url;
    //是否启用
    private Boolean enable;
    //服务名称
    private String service;

    //用于发送HTTP数据
    private RestTemplate restTemplate = new RestTemplate();


    @Override
    protected void append(ILoggingEvent eventObject) {
        if(eventObject != null && eventObject.getMessage() != null && this.enable){
            this.sendMsg(eventObject);
        }
    }

    /**
     * 发送Post请求
     * @param event
     */
    private void sendMsg(ILoggingEvent event){

        Map<String, Object> json = Maps.newHashMap();
        Map<String, Object> contentJson = Maps.newHashMap();
        contentJson.put("content", this.buildMsg(event));
        json.put("msgtype", "text");
        json.put("text", contentJson);
        this.restTemplate.postForEntity(this.url,json,Map.class);
    }

    private String buildMsg(ILoggingEvent event ){
        StringBuffer msg = new StringBuffer();
        msg.append("时间："+ new Timestamp(event.getTimeStamp()).toString());
        msg.append("\n");
        if(!Strings.isNullOrEmpty(this.getService())){
            msg.append("服务名称：");
            msg.append(this.getService());
            msg.append("\n");
        }
        msg.append("描述：");
        msg.append(event.getMessage());
        return msg.toString();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
