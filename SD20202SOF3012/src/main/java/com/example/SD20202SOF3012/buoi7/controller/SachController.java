package com.example.SD20202SOF3012.buoi7.controller;

import com.example.SD20202SOF3012.buoi7.model.Sach;
import com.example.SD20202SOF3012.buoi7.model.TheLoai;
import com.example.SD20202SOF3012.buoi7.repository.SachRepository;
import com.example.SD20202SOF3012.buoi7.repository.TheLoaiRepository;
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
    TheLoaiRepository theLoaiRepository = new TheLoaiRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            deleteSach(req, resp);
        }
    }

    private void deleteSach(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        sachRepository.deleteSach(id);
        resp.sendRedirect("/buoi7/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sach", sachRepository.getOne(id));
        req.setAttribute("listTheLoai", theLoaiRepository.getAll());
        req.getRequestDispatcher("/buoi7/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTheLoai", theLoaiRepository.getAll());
        req.setAttribute("listSach", sachRepository.getAll());
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

        TheLoai theLoai = theLoaiRepository.getOne(idTheLoai);
        // Tao sach moi
        Sach sach = new Sach(id, tenSach, tacGia, gia, soLuong, conHang, theLoai);

        // Update sach
        sachRepository.updateSach(sach);
        resp.sendRedirect("/buoi7/hien-thi");
    }

    private void addSach(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenSach = req.getParameter("tenSach");
        String tacGia = req.getParameter("tacGia");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean conHang = Boolean.valueOf(req.getParameter("conHang"));
        Integer idTheLoai = Integer.valueOf(req.getParameter("theLoai"));

        TheLoai theLoai = theLoaiRepository.getOne(idTheLoai);
        // Tao sach moi
        Sach sach = new Sach(null, tenSach, tacGia, gia, soLuong, conHang, theLoai);

        // Them sach
        sachRepository.addSach(sach);
        resp.sendRedirect("/buoi7/hien-thi");
    }
}
