package com.test.demos.service;

import com.test.demos.entity.Users;
import com.test.demos.mapper.UsersMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 描述:
 *
 * @author caoXB
 * @date 2020/3/19 18:14
 */
@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int register(Users users) {
        Users umsAdmin = new Users();
        BeanUtils.copyProperties(users, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        return usersMapper.insert(users);
    }
}
