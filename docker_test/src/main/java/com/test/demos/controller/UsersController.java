package com.test.demos.controller;

import com.test.demos.entity.Users;
import com.test.demos.service.IUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 *
 * @author caoXB
 * @date 2020/3/19 17:42
 */
@Api(tags = "UmsAdminController", description = "用户管理")
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    @ApiOperation(value = "欢迎接口")
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to My Docker demos!!";
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public String register(@RequestBody Users users) {
        int i = usersService.register(users);
        if (i != 1) {
            return "register error!";
        } else {
            return "register successful!!";
        }
    }
}
