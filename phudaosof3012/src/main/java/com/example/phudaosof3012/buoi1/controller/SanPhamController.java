package com.example.phudaosof3012.buoi1.controller;

import com.example.phudaosof3012.buoi1.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sanPhamController", value = {
        "/san-pham/hien-thi"
})
public class SanPhamController extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSanPham", sanPhamRepository.getAll());
        req.getRequestDispatcher("/views/buoi1/hienThi.jsp").forward(req, resp);
    }
}
