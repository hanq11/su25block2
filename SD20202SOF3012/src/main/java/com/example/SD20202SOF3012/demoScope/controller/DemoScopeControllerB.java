package com.example.SD20202SOF3012.demoScope.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "demoScopeControllerB", value = {
        "/scope-b"
})
public class DemoScopeControllerB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request scope
        String name = (String) req.getAttribute("name");
        System.out.println("Request scope: " + name);

        // Session scope
        HttpSession session = req.getSession();
        String truong = (String) session.getAttribute("truong");
        System.out.println("Session scope: " + truong);

        // Application scope
        ServletContext servletContext = getServletContext();
        String diaChi = (String) servletContext.getAttribute("diaChi");
        System.out.println("Application scope: " + diaChi);

        req.getRequestDispatcher("/demoScope/hien-thi.jsp").forward(req, resp);
    }
}
