package com.example.demo.util;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 用户实体类
 */
@Data
@ToString
public class UserEntity {

    @Excel(name = "ID")
    private int id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "电子邮件",width = 20)
    private String email;

    @Excel(name = "年龄")
    private int age;

    @Excel(name = "性别",replace={"男_1", "女_2"})
    private int sex;

    @Excel(name = "操作时间",format="yyyy-MM-dd HH:mm:ss",width = 20)
    private Date time;

}
