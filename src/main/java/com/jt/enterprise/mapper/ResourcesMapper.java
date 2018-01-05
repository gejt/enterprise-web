package com.jt.enterprise.mapper;

import com.jt.enterprise.domain.Resources;

public interface ResourcesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);
}