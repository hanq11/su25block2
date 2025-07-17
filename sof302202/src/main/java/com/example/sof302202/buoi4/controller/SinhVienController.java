package com.example.sof302202.buoi4.controller;

import com.example.sof302202.buoi4.model.SinhVien;
import com.example.sof302202.buoi4.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", sinhVienService.getAll());
        return "/buoi4/hienThi";
    }

    @PostMapping("/add")
    public String addSinhVien(SinhVien sv) {
        sinhVienService.addSinhVien(sv);
        return "redirect:/sinh-vien/hien-thi";
    }
}
