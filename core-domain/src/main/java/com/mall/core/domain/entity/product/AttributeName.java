package com.mall.core.domain.entity.product;

import com.mall.core.domain.entity.BaseEntity;
import com.mall.core.domain.enumeration.product.AttributeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttributeName extends BaseEntity implements Serializable {
    private Long id;

    private String name;

    private AttributeTypeEnum type;
}