package com.lf.backmanage.controller;

import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.Student;
import com.lf.backmanage.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    StudentMapper studentMapper;
    @PostMapping("/add")
    public Result<?> Save(@RequestBody Student student){
      studentMapper.insert(student);
        return Result.success();
    }
    @PutMapping("/update")
    public Result<?> update(@RequestBody Student student){

        studentMapper.updateById(student);
        System.out.println("daoci");
        return Result.success();
    }
}
