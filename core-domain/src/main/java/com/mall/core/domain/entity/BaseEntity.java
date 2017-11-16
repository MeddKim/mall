package com.mall.core.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    protected Boolean isAvailable;

    protected Boolean isDeleted;

    protected Integer versionNo;

    protected Long createUserid;    //创建人ID

    protected String createUsername;  //创建人名称

    protected String createUserip;   //创建人IP

    protected String createUsermac;  //创建人Mac地址

    protected Timestamp createTime;  //创建时间

    protected Timestamp createTimeDb;

    protected String serverIp;  //服务器Ip

    private Long updateUserid;  //最后修改人ID

    private String updateUsername; //最后修改人名称

    private String updateUserip;  //最后修改人IP

    private String updateUsermac; //最后修改人Mac地址

    private Date updateTime;   //最后更新时间

    private Date updateTimeDb;

    private String clientVersionno;  //客户端版本号


}