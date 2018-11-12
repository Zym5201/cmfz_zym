package com.baizhi.service;
import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional()
public class CourseServiceImpl  implements CourseService{
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> queryAllCourse(int start, int rows) {
        return courseDao.queryByPage(start,rows);
    }

    @Override
    public Integer total_Course() {
        return courseDao.total();
    }

    @Override
    public void save(Course course) {
        course.setId(UUID.randomUUID().toString());
        courseDao.insert(course);
    }

    @Override
    public void delete(String id) {
        courseDao.deleteOneById(id);
    }


    @Override
    public void update(Course course) {
        courseDao.update(course);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Course queryOneById(String id) {
        return courseDao.queryOne(id);
    }
}
