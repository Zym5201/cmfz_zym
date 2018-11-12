package com.baizhi.service;


import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> queryAllCourse(int start, int rows);

    Integer total_Course();

    void save(Course course);

    void delete(String id);

    void update(Course course);

    Course  queryOneById(String id);

}
