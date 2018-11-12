package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("course")
public class CourseController {
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @RequestMapping("queryAllCourse")
    public @ResponseBody
    Map<String, Object> queryAllByPageAndRows(int page, int rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer total = courseService.total_Course();
        int start = (page - 1) * rows;
        List<Course> courses = courseService.queryAllCourse(start, rows);
        map.put("total", total);
        map.put("rows", courses);
        return map;
    }


    @RequestMapping("deleteRow")
    public @ResponseBody
    Map<String, Object> deleteRow(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            courseService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping("update")
    public @ResponseBody
    Map<String, Object> update(Course course) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            courseService.update(course);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping("save")
    public @ResponseBody
    Map<String, Object> insert(Course course) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            final Date creatTime = course.getCreatTime(new Date());
            courseService.save(course);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping("queryOneById")
    public @ResponseBody
    Course queryOne(String id) {
        Course course = courseService.queryOneById(id);
        return course;
    }
}

