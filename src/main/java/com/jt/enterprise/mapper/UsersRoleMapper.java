package com.jt.enterprise.mapper;

import com.jt.enterprise.domain.UsersRole;

public interface UsersRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UsersRole record);

    int insertSelective(UsersRole record);

    UsersRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersRole record);

    int updateByPrimaryKey(UsersRole record);
}