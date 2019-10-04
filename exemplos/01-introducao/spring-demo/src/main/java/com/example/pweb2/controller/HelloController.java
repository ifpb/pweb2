package com.example.pweb2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello2")
    public ModelAndView hello() {
        ModelAndView model = new ModelAndView("index.html");
        model.addObject("nome", "Diego");
        return model;
    }

}
