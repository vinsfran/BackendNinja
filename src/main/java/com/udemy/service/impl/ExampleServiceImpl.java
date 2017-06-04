package com.udemy.service.impl;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

    public static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);
    
    @Override    
    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jon", 23));
        people.add(new Person("Mikel", 30));
        people.add(new Person("Eva", 43));
        people.add(new Person("Peter", 18));
        LOGGER.info("HELLO FROM SERVICE");
        return people;
    }
    
}
