package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {
    
    public static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);
    
    public void sayHello(){
        LOGGER.info("HELLO FROM EXAMPLECOMPONENT");
    }
}
