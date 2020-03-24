package com.test.demos.mapper;

import com.test.demos.entity.Users;
import com.test.demos.entity.UsersExample;

import java.util.List;

public interface UsersMapper {
    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);


}