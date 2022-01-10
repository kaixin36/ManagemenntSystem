package com.lf.backmanage.controller;



import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.Course;
import com.lf.backmanage.mapper.CourseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
    CourseMapper courseMapper;
    @PostMapping("/save")
    public Result<?> Save(@RequestBody Course course){
    courseMapper.insert(course);
        return Result.success();

    }
}
