package com.lf.backmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("student")
@Data

public class Student {
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;
    private String name;
    private Integer age;
    private String number;
}
