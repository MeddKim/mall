package com.mall.core.domain.entity.product;

import com.mall.core.domain.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeName extends BaseEntity implements Serializable {
    private Long id;

    private String name;

    private Integer type;

    private Long companyId;

    private static final long serialVersionUID = 1L;

}