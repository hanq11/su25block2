package com.example.sof302202.buoi8.controller;

import com.example.sof302202.buoi8.model.PhongKham;
import com.example.sof302202.buoi8.repository.PhongKhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phong-kham")
public class PhongKhamController {
    @Autowired
    PhongKhamRepository phongKhamRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", phongKhamRepository.findAll());
        return "/buoi8/hienThi";
    }

    @PostMapping("/add")
    public String addPhongKham(PhongKham phongKham) {
        phongKhamRepository.save(phongKham);
        return "redirect:/phong-kham/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("phongKham", phongKhamRepository.findById(id).get());
        return "/buoi8/viewUpdate";
    }

    @PostMapping("/update")
    public String updatePhongKham(PhongKham phongKham) {
        phongKhamRepository.save(phongKham);
        return "redirect:/phong-kham/hien-thi";
    }

    @GetMapping("/delete")
    public String deletePhongKham(@RequestParam("id") Integer id) {
        phongKhamRepository.deleteById(id);
        return "redirect:/phong-kham/hien-thi";
    }
}
