package com.lf.backmanage.controller;

import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.Teacher;
import com.lf.backmanage.mapper.TeacherMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

@RequestMapping("/teacher")
public class TeacherController {
@Resource
    TeacherMapper teacherMapper;
@PostMapping("/save")
 public Result<?> Save(@RequestBody Teacher teacher){
     teacherMapper.insert(teacher);
     return Result.success();
 }
}
