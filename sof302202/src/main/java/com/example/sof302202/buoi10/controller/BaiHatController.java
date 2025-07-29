package com.example.sof302202.buoi10.controller;

import com.example.sof302202.buoi10.repository.BaiHatRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bai-hat")
public class BaiHatController {
    @Autowired
    BaiHatRepository baiHatRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listBaiHat", baiHatRepository.findAll());
        return "/buoi10/hien-thi";
    }
}
