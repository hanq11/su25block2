package com.example.sof302202.deMau1.controller;

import com.example.sof302202.deMau1.model.ChucVu;
import com.example.sof302202.deMau1.repository.ChucVuRepository;
import com.example.sof302202.deMau1.repository.NhanVienRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/de-mau-1")
public class DeMau1Controller {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    ChucVuRepository chucVuRepository;

    @ModelAttribute("listChucVu")
    public List<ChucVu> getListChucVu() {
        return chucVuRepository.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listNhanVien", nhanVienRepository.findAll());
        return "deMau1/hien-thi";
    }
}
