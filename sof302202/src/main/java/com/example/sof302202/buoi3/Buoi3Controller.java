package com.example.sof302202.buoi3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/buoi3")
public class Buoi3Controller {
    @GetMapping("/pv/{id}")
    public String testPV(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "/buoi3/pv";
    }

    @ModelAttribute("name")
    public String getName() {
        return "123";
    }

    @GetMapping("/kieu3")
    public String testKieu3() {
        return "/buoi3/demo";
    }

    @GetMapping("/url1")
    public String url1() {
        return "/buoi3/demo";
    }

    @GetMapping("/url3")
    public String url3() {
        return "forward:/buoi3/url1";
    }

    @GetMapping("/url4")
    public String url4() {
        return "redirect:/buoi3/url1";
    }

    @ResponseBody
    @GetMapping("/json")
    public Login testJson() {
        return new Login("123", "234", true);
    }
}
