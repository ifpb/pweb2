package br.edu.ifpb.pweb2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("index.html");
        mav.addObject("nome", "Diego");
        return mav;
    }

}
