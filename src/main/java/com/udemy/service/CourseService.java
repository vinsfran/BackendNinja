package com.udemy.service;

import com.udemy.entity.Course;
import java.util.List;


public interface CourseService {
    
    public abstract List<Course> listAllCourses();
    public abstract Course addCourse(Course course);
    public abstract int removeCourse(int id);
    public abstract Course updateCourse(Course course);
    
}
