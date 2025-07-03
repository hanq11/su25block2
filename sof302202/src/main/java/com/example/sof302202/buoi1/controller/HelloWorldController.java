package com.example.sof302202.buoi1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/hello-world") // Handler mapping
    public String helloWorld(Model model) { // Controller
        model.addAttribute("ten", "SD20202");
        return "/buoi1/helloWorld";
    }
}
