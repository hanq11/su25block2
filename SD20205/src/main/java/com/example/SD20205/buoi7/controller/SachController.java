package com.example.SD20205.buoi7.controller;

import com.example.SD20205.buoi7.model.Sach;
import com.example.SD20205.buoi7.model.TheLoai;
import com.example.SD20205.buoi7.repository.SachRepository;
import com.example.SD20205.buoi7.repository.TheLoaiRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sachController", value = {
        "/sach/hien-thi", // GET
        "/sach/delete", // GET
        "/sach/view-update", // GET
        "/sach/update", // POST
        "/sach/add" // POST
})
public class SachController extends HttpServlet {
    SachRepository sachRepository = new SachRepository();
    TheLoaiRepository theLoaiRepository = new TheLoaiRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer idSach = Integer.valueOf(req.getParameter("id"));
        sachRepository.delete(idSach);
        resp.sendRedirect("/sach/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idSach = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sach", sachRepository.getOne(idSach));
        req.setAttribute("listTheLoai", theLoaiRepository.getAll());
        req.getRequestDispatcher("/buoi7/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSach", sachRepository.getAll());
        req.setAttribute("listTheLoai", theLoaiRepository.getAll());
        req.getRequestDispatcher("/buoi7/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addSach(req, resp);
        } else if(uri.contains("update")) {
            updateSach(req, resp);
        }
    }

    private void updateSach(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenSach = req.getParameter("tenSach");
        String tacGia = req.getParameter("tacGia");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean conHang = Boolean.valueOf(req.getParameter("conHang"));

        Integer idTheLoai = Integer.valueOf(req.getParameter("theLoai"));

        // Get the loai
        TheLoai theLoai = theLoaiRepository.getOne(idTheLoai);

        // Sua sach
        Sach sach = new Sach(id, tenSach, tacGia, gia, soLuong, conHang, theLoai);
        sachRepository.update(sach);
        resp.sendRedirect("/sach/hien-thi");
    }

    private void addSach(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenSach = req.getParameter("tenSach");
        String tacGia = req.getParameter("tacGia");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean conHang = Boolean.valueOf(req.getParameter("conHang"));

        Integer idTheLoai = Integer.valueOf(req.getParameter("theLoai"));

        // Get the loai
        TheLoai theLoai = theLoaiRepository.getOne(idTheLoai);

        // Them sach
        Sach sach = new Sach(null, tenSach, tacGia, gia, soLuong, conHang, theLoai);
        sachRepository.add(sach);
        resp.sendRedirect("/sach/hien-thi");
    }
}
