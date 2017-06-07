package com.udemy.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
    
    private QCourse qCourse = QCourse.course;
    
    @PersistenceContext
    private EntityManager em;
    
    public Course find(boolean exist){
        
        JPAQuery<Course> query = new JPAQuery<Course>(em);
        
        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
        
        Predicate predicate;
        if(exist){
            predicate = qCourse.id.eq(23);
            predicateBuilder.and(predicate);
        }else{
            predicate = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate);
        }
        
        return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
    }
}
