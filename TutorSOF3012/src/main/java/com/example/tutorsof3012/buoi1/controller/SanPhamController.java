package com.example.tutorsof3012.buoi1.controller;

import com.example.tutorsof3012.buoi1.model.SanPham;
import com.example.tutorsof3012.buoi1.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sanPhamController", value = {
        "/san-pham/hien-thi", // GET
        "/san-pham/add", // POST
        "/san-pham/view-update", // GET
        "/san-pham/update", // POST
        "/san-pham/delete", // GET
        "/san-pham/search", // GET
        "/san-pham/sort", // GET
})
public class SanPhamController extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        } else if(uri.contains("search")) {
            searchByTen(req, resp);
        } else if(uri.contains("sort")) {
            sortByNhaSanXuat(req, resp);
        }
    }

    private void sortByNhaSanXuat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", sanPhamRepository.sortByNhaSanXuat());
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req, resp);
    }

    private void searchByTen(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenSanPham = req.getParameter("tenSanPham");
        req.setAttribute("danhSach", sanPhamRepository.searchByTen(tenSanPham));
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        sanPhamRepository.deleteSanPham(id);
        // DB co thay doi - redirect
        resp.sendRedirect("/san-pham/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sanPham", sanPhamRepository.getOne(id));
        req.getRequestDispatcher("/buoi1/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", sanPhamRepository.getAll());
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addSanPham(req, resp);
        } else if(uri.contains("update")) {
            updateSanPham(req, resp);
        }
    }

    private void updateSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenSanPham = req.getParameter("tenSanPham");
        String nhaSanXuat = req.getParameter("nhaSanXuat");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean conHang = Boolean.valueOf(req.getParameter("conHang"));

        // Tao san pham
        SanPham sanPham = new SanPham(id, tenSanPham, nhaSanXuat, gia, soLuong, conHang);

        // Sua san pham trong db
        sanPhamRepository.updateSanPham(sanPham);

        // DB co thay doi - redirect
        resp.sendRedirect("/san-pham/hien-thi");
    }

    private void addSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenSanPham = req.getParameter("tenSanPham");
        String nhaSanXuat = req.getParameter("nhaSanXuat");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean conHang = Boolean.valueOf(req.getParameter("conHang"));

        // Tao san pham moi
        SanPham sanPham = new SanPham(null, tenSanPham, nhaSanXuat, gia, soLuong, conHang);

        // Them san pham vao db
        sanPhamRepository.addSanPham(sanPham);

        // DB co thay doi - redirect
        resp.sendRedirect("/san-pham/hien-thi");
    }
}
