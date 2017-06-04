package com.udemy.controller;

import com.udemy.model.Person;
import java.util.ArrayList;
import java.util.List;
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

    //Primera forma con datos simples
    @GetMapping(value = "/exampleSimpleString")
    public String exampleSimpleString(Model model) {
        model.addAttribute("name", "Jon");
        return EXAMPLE_SIMPLE_VIEW;
    }

    //Segunda forma con datos simples
    @GetMapping(value = "/exampleSimpleMAV")
    public ModelAndView exampleSimpleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_SIMPLE_VIEW);
        mav.addObject("name", "Mikel");
        return mav;
    }

    //Primera forma con objetos
    @GetMapping(value = "/exampleObjetoString")
    public String exampleObjetoString(Model model) {
        model.addAttribute("person", new Person("Jon", 23));
        return EXAMPLE_OBJETO_VIEW;
    }

    //Segunda forma con objetos
    @GetMapping(value = "/exampleObjetoMAV")
    public ModelAndView exampleObjetoMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_OBJETO_VIEW);
        mav.addObject("person", new Person("Mikel", 30));
        return mav;
    }
    
    //Primera forma con lista de objetos
    @GetMapping(value = "/exampleListaObjetoString")
    public String exampleListaObjetoString(Model model) {
        model.addAttribute("people", getPeople());
        return EXAMPLE_LISTA_OBJETO_VIEW;
    }

    //Segunda forma con lista de objetos
    @GetMapping(value = "/exampleListaObjetoMAV")
    public ModelAndView exampleListaObjetoMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_LISTA_OBJETO_VIEW);
        mav.addObject("people", getPeople());
        return mav;
    }

    private List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jon", 23));
        people.add(new Person("Mikel", 30));
        people.add(new Person("Eva", 43));
        people.add(new Person("Peter", 18));
        return people;
    }
}
