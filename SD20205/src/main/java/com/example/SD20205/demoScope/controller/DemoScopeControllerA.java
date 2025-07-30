package com.example.SD20205.demoScope.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "demoScopeControllerA", value = {
        "/scope-a"
})
public class DemoScopeControllerA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request scope
        req.setAttribute("name", "SD20205");

        // Session scope
        HttpSession session = req.getSession();
        session.setAttribute("role", "admin");

        // Application scope
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("scope", "application");

        req.getRequestDispatcher("/scope-b").forward(req, resp);
    }

}
