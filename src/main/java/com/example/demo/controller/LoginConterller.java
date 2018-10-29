package com.example.demo.controller;

import com.example.demo.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2018/10/29/029 09:49
 * @Version: 1.0
 * @Description:
 */
@RestController
@Api(value = "用户相关api", description = "测试登录")
public class LoginConterller {
    private List<User> userList;


    @ApiOperation(value = "测试用户登录", notes = "用户登录")
    @GetMapping(value = "/username")
    public String getLoginUserName(@Valid @ApiParam(value = "用户名", required = true) String userName, @ApiParam(value = "年龄", required = true) Integer age){
        return userName + " --- " + age;
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "userName", dataType = "String", required = true, value = "用户名", defaultValue = "zhangsan"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户密码", defaultValue = "123456")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数错误"),
            @ApiResponse(code = 404, message = "请求参数路径不对"),
            @ApiResponse(code = 401, message = "没有相关权限")
    })
    @GetMapping(value = "/getUser")
    public User getUser (@RequestHeader("userName") String userName, @RequestParam("password") String password){
        return User.builder().userName(userName).password(password).build();
    }
    @ApiOperation(value = "创建用户", notes = "根据User 对象创建用户信息")
    @ApiImplicitParam(name = "user", value = "用户对象详情", required = true, dataType = "User")
    @PostMapping("postUser")
    public String postUser(@RequestBody User user){
        userList.add(user);
        return "success";
    }
    @ApiIgnore
    @GetMapping("/")
    public String home(){
        return "Hello --> ";
    }
}
