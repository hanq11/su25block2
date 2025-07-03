package com.example.sof302202.buoi2.controller;

import com.example.sof302202.buoi2.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/buoi2")
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "/buoi2/form";
    }

//    @PostMapping("/login")
//    public String login(
//            @RequestParam("username") String user,
//            @RequestParam("password") String pass,
//            @RequestParam(name = "remember", defaultValue = "false") Boolean rm,
//            Model model
//    ) {
//        model.addAttribute("username", user);
//        model.addAttribute("password", pass);
//        model.addAttribute("remember", rm);
//        return "/buoi2/thongTin";
//    }

    @PostMapping("/login")
    public String login(Login login, Model model) {
        model.addAttribute("username", login.getUsername());
        model.addAttribute("password", login.getPassword());
        model.addAttribute("remember", login.getRemember());
        return "/buoi2/thongTin";
    }
}
