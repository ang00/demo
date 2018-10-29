package com.example.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Auther: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2018/10/29/029 09:50
 * @Version: 1.0
 * @Description:
 */
@Data
@Builder
public class User {
    @ApiModelProperty(value = "主键id")
    private Long id;

    @NotNull(message = "请输入用户名")
    @ApiModelProperty(value = "姓名", name = "userName", example = "zhangsan", required = true)
    private String userName;

    @NotNull(message = "请输入年龄")
    @ApiModelProperty(value = "年龄", name = "age", example = "18", required = true)
    @Pattern(regexp = "([0-9]|[0-9]{2}|120)", message = "年龄必须是小于120的正整数")
    private Integer age;

    @ApiModelProperty(value = "密码")
    private String password;
}
