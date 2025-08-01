package com.example.SD20202SOF3012.demoFilter.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "quanLyController", value = {
        "/quan-ly/hien-thi"
})
public class QuanLyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/demoFilter/hien-thi.jsp").forward(req, resp);
    }
}
