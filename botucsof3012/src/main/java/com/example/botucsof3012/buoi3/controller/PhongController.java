package com.example.botucsof3012.buoi3.controller;

import com.example.botucsof3012.buoi3.model.KhachSan;
import com.example.botucsof3012.buoi3.model.Phong;
import com.example.botucsof3012.buoi3.repository.KhachSanRepository;
import com.example.botucsof3012.buoi3.repository.PhongRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "phongController", value = {
        "/buoi3/hien-thi", // GET
        "/buoi3/xoa", // GET
        "/buoi3/them", // POST
        "/buoi3/view-update", // GET
        "/buoi3/update", // POST
})
public class PhongController extends HttpServlet {
    PhongRepository phongRepository = new PhongRepository();
    KhachSanRepository khachSanRepository = new KhachSanRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoaPhong(req, resp);
        }
    }

    private void xoaPhong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer idPhong = Integer.valueOf(req.getParameter("id"));
        phongRepository.xoaPhong(idPhong);
        resp.sendRedirect("/buoi3/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listKhachSan", khachSanRepository.getAllKhachSan());
        Integer idPhong = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("phong", phongRepository.getPhong(idPhong));
        req.getRequestDispatcher("/buoi3/viewUpdate.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listKhachSan", khachSanRepository.getAllKhachSan());
        req.setAttribute("listPhong", phongRepository.getAllPhong());
        req.getRequestDispatcher("/buoi3/hienThi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themPhong(req, resp);
        } else if(uri.contains("update")) {
            updatePhong(req, resp);
        }
    }

    private void updatePhong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenPhong = req.getParameter("tenPhong");
        Integer gia = Integer.valueOf(req.getParameter("gia"));
        Boolean conTrong = Boolean.valueOf("conTrong");

        // Tim thuc the khachSan
        Integer khachSanId = Integer.valueOf(req.getParameter("khachSan"));
        KhachSan khachSan = khachSanRepository.getKhachSan(khachSanId);

        // Tao thuc the phong
        Phong phong = new Phong(id, tenPhong, gia, conTrong, khachSan);

        // Them phong vao trong db
        phongRepository.suaPhong(phong);

        resp.sendRedirect("/buoi3/hien-thi");
    }

    private void themPhong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenPhong = req.getParameter("tenPhong");
        Integer gia = Integer.valueOf(req.getParameter("gia"));
        Boolean conTrong = Boolean.valueOf("conTrong");

        // Tim thuc the khachSan
        Integer khachSanId = Integer.valueOf(req.getParameter("khachSan"));
        KhachSan khachSan = khachSanRepository.getKhachSan(khachSanId);

        // Tao thuc the phong
        Phong phong = new Phong(null, tenPhong, gia, conTrong, khachSan);

        // Them phong vao trong db
        phongRepository.themPhong(phong);

        resp.sendRedirect("/buoi3/hien-thi");
    }
}
