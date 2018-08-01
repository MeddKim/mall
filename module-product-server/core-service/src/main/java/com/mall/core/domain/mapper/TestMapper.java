package com.mall.core.domain.mapper;

import com.mall.core.domain.entity.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

    void insert(Test test);
}
