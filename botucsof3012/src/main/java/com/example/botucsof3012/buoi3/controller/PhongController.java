package com.example.botucsof3012.buoi3.controller;

import com.example.botucsof3012.buoi3.model.Phong;
import com.example.botucsof3012.buoi3.repository.PhongRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "phongController", value = {
        "/buoi3/hien-thi", // GET
        "/buoi3/chi-tiet", // GET
        "/buoi3/xoa", // GET
        "/buoi3/them", // POST
        "/buoi3/view-update", // GET
        "/buoi3/update", // POST
})
public class PhongController extends HttpServlet {
    PhongRepository phongRepository = new PhongRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listPhong", phongRepository.getAllPhong());
        req.getRequestDispatcher("/buoi3/hienThi.jsp").forward(req, resp);
    }
}
