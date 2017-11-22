package com.mall.core.domain.entity.product;

import com.mall.core.domain.entity.BaseEntity;
import com.mall.core.domain.enumeration.product.AttributeValueTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeValue extends BaseEntity implements Serializable {
    private Long id;

    private Long parentId;

    private Long attributeNameId;

    private String value;

    private Integer sortValue;

    private AttributeValueTypeEnum type;

    private static final long serialVersionUID = 1L;

}