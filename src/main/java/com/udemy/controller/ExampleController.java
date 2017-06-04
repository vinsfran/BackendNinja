package com.udemy.controller;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_SIMPLE_VIEW = "exampleSimple";
    public static final String EXAMPLE_OBJETO_VIEW = "exampleObjeto";
    public static final String EXAMPLE_LISTA_OBJETO_VIEW = "exampleListaObjeto";

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;
    
    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent exampleComponent;
    
    //Primera forma con datos simples
    @GetMapping("/exampleSimpleString")
    public String exampleSimpleString(Model model) {
        exampleComponent.sayHello();
        model.addAttribute("name", "Jon");
        return EXAMPLE_SIMPLE_VIEW;
    }

    //Segunda forma con datos simples
    @GetMapping("/exampleSimpleMAV")
    public ModelAndView exampleSimpleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_SIMPLE_VIEW);
        mav.addObject("name", "Mikel");
        return mav;
    }

    //Primera forma con objetos
    @GetMapping("/exampleObjetoString")
    public String exampleObjetoString(Model model) {
        model.addAttribute("person", new Person("Jon", 23));
        return EXAMPLE_OBJETO_VIEW;
    }

    //Segunda forma con objetos
    @GetMapping("/exampleObjetoMAV")
    public ModelAndView exampleObjetoMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_OBJETO_VIEW);
        mav.addObject("person", new Person("Mikel", 30));
        return mav;
    }
    
    //Primera forma con lista de objetos
    @GetMapping("/exampleListaObjetoString")
    public String exampleListaObjetoString(Model model) {
        model.addAttribute("people", exampleService.getPeople());
        return EXAMPLE_LISTA_OBJETO_VIEW;
    }

    //Segunda forma con lista de objetos
    @GetMapping("/exampleListaObjetoMAV")
    public ModelAndView exampleListaObjetoMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_LISTA_OBJETO_VIEW);
        mav.addObject("people", exampleService.getPeople());
        return mav;
    }

}
