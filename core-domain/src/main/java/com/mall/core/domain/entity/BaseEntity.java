package com.mall.core.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    protected Boolean isAvailable;   //是否启用

    protected Boolean isDeleted;    //是否删除

    protected Integer versionNo;    //数据版本

    protected Long createUserid;    //创建人ID

    protected String createUsername;  //创建人名称

    protected String createUserip;   //创建人IP

    protected String createUsermac;  //创建人Mac地址

    protected LocalDateTime createTime;  //创建时间

    protected LocalDateTime createTimeDb;

    protected String serverIp;  //服务器Ip

    protected Long updateUserid;  //最后修改人ID

    protected String updateUsername; //最后修改人名称

    protected String updateUserip;  //最后修改人IP

    protected String updateUsermac; //最后修改人Mac地址

    protected LocalDateTime updateTime;   //最后更新时间

    protected LocalDateTime updateTimeDb;

    protected String clientVersionno;  //客户端版本号

    protected Long companyId;  //公司ID

}