package com.udemy.converter;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import org.springframework.stereotype.Component;

@Component("courseConverter")
public class CourseConverter {
    
    //Entity --> Model
    public CourseModel entity2model(Course course){
        CourseModel courseModel = new CourseModel(course.getName(), course.getDescription(), course.getPrice(), course.getHours());
        return courseModel;
    }    
    
    //Model --> Entity
    public Course model2entity(CourseModel courseModel){
        Course course = new Course(courseModel.getName(), courseModel.getDescription(), courseModel.getPrice(), courseModel.getHours());
        return course;
    }
}
