package com.example.SD20202SOF3012.demoFilter.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginController", value = {
        "/demo-filter/login",
        "/demo-filter/logout"
})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("login")) {
            req.getRequestDispatcher("/demoFilter/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect("/demo-filter/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        if(
                username.equals("admin") && password.equals("123")
                || username.equals("employee") && password.equals("234")
        ) {
            session.setAttribute("username", username);
            if(username.equals("admin")) {
                session.setAttribute("role", "adminPermission");
                resp.sendRedirect("/quan-ly/hien-thi");
            } else {
                session.setAttribute("role", "employeePermission");
                resp.sendRedirect("/nhan-vien/hien-thi");
            }
        } else {
            req.setAttribute("message", "Thong tin dang nhap sai");
            req.getRequestDispatcher("/demoFilter/login.jsp").forward(req, resp);
        }
    }
}
