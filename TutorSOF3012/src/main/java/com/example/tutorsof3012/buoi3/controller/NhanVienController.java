package com.example.tutorsof3012.buoi3.controller;

import com.example.tutorsof3012.buoi3.repository.NhanVienRepository;
import com.example.tutorsof3012.buoi3.repository.PhongBanRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "nhanVienController", value = {
        "/nhan-vien/hien-thi", // GET
        "/nhan-vien/delete", // GET
        "/nhan-vien/view-update", // GET
        "/nhan-vien/update", // POST
        "/nhan-vien/add" // POST
})
public class NhanVienController extends HttpServlet {
    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    PhongBanRepository phongBanRepository = new PhongBanRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listPhongBan", phongBanRepository.getAll());
        req.setAttribute("danhSach", nhanVienRepository.getAll());
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req, resp);
    }
}
