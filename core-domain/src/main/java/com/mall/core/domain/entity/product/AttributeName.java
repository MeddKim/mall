package com.mall.core.domain.entity.product;

import com.mall.core.domain.entity.BaseEntity;
import com.mall.core.domain.enumeration.product.AttributeTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeName extends BaseEntity implements Serializable {
    private Long id;

    private String name;

    private AttributeTypeEnum type;
}