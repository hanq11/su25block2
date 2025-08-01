package com.example.SD20202SOF3012.demoFilter.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "nhanVienController", value = {
        "/nhan-vien/hien-thi"
})
public class NhanVienController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/demoFilter/hien-thi.jsp").forward(req, resp);
    }
}
