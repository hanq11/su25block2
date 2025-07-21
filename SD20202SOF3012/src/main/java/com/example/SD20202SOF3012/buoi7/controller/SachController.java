package com.example.SD20202SOF3012.buoi7.controller;

import com.example.SD20202SOF3012.buoi7.model.Sach;
import com.example.SD20202SOF3012.buoi7.repository.SachRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sachController", value = {
        "/buoi7/hien-thi", // GET
        "/buoi7/delete", // GET
        "/buoi7/view-update", // GET
        "/buoi7/update", // POST
        "/buoi7/add" // POST
})
public class SachController extends HttpServlet {
    SachRepository sachRepository = new SachRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSach", sachRepository.getAll());
        req.getRequestDispatcher("/buoi7/hien-thi.jsp").forward(req, resp);
    }
}
