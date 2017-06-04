package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

    public static final String ERROR_404_VIEW = "404";
    public static final String ERROR_500_VIEW = "500";

    @GetMapping("/404")
    public String show404(Model model) {
        return ERROR_404_VIEW;
    }

    @GetMapping("/500")
    public String show500(Model model) {
        return ERROR_500_VIEW;
    }

}
