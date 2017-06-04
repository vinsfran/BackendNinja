package com.udemy.controller;

import com.udemy.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    public static final String FORM_VIEW = "form";
    public static final String RESULT_VIEW = "result";

    //Primera forma de redireccion
//    @GetMapping("/")
//    public String redirect(){
//        return "redirect:/example3/showform";
//    }
    
    //Segunda forma de redireccion
    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/example3/showform");
    }
    
    @GetMapping("/showform")
    public String showform(Model model) {
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addperson(@ModelAttribute("person") Person person) {
        ModelAndView mav = new ModelAndView(RESULT_VIEW);
        mav.addObject("person", person);
        return mav;
    }
        
}
