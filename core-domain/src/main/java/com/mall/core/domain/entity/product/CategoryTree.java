package com.mall.core.domain.entity.product;

import com.mall.core.domain.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryTree extends BaseEntity implements Serializable {
    private Long id;

    private Integer type;

    private String name;

    private String description;

    private static final long serialVersionUID = 1L;

}