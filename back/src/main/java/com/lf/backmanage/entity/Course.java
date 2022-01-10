package com.lf.backmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("course")
@Data
public class Course {
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;
    private String name;
    private String teacher;
}
