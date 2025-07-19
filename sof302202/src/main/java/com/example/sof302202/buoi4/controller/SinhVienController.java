package com.example.sof302202.buoi4.controller;

import com.example.sof302202.buoi4.model.SinhVien;
import com.example.sof302202.buoi4.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sv", sinhVienService.getDetail(id));
        return "/buoi4/viewUpdate";
    }

    @PostMapping("/update")
    public String update(SinhVien sinhVien) {
        sinhVienService.updateSinhVien(sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        sinhVienService.deleteSinhVien(id);
        return "redirect:/sinh-vien/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sv", sinhVienService.getDetail(id));
        return "/buoi4/detail";
    }
}
