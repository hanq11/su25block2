package com.example.sof302202.buoi10.controller;

import com.example.sof302202.buoi10.model.BaiHat;
import com.example.sof302202.buoi10.model.CaSi;
import com.example.sof302202.buoi10.repository.BaiHatRepository;
import com.example.sof302202.buoi10.repository.CaSiRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bai-hat")
public class BaiHatController {
    @Autowired
    BaiHatRepository baiHatRepository;

    @Autowired
    CaSiRepository caSiRepository;

    @ModelAttribute("listCaSi")
    public List<CaSi> getListCaSi() {
        return caSiRepository.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listBaiHat", baiHatRepository.findAll());
        return "/buoi10/hien-thi";
    }

    @PostMapping("/them")
    public String themBaiHat(BaiHat baiHat) {
        baiHatRepository.save(baiHat);
        return "redirect:/bai-hat/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("baiHat", baiHatRepository.findById(id).get());
        return "/buoi10/view-update";
    }

    @PostMapping("/update")
    public String update(BaiHat baiHat) {
        baiHatRepository.save(baiHat);
        return "redirect:/bai-hat/hien-thi";
    }

    @GetMapping("/xoa")
    public String xoa(@RequestParam("id") Integer id) {
        baiHatRepository.deleteById(id);
        return "redirect:/bai-hat/hien-thi";
    }
}
