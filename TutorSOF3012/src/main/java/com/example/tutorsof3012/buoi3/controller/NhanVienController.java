package com.example.tutorsof3012.buoi3.controller;

import com.example.tutorsof3012.buoi3.model.NhanVien;
import com.example.tutorsof3012.buoi3.model.PhongBan;
import com.example.tutorsof3012.buoi3.repository.NhanVienRepository;
import com.example.tutorsof3012.buoi3.repository.PhongBanRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "nhanVienController", value = {
        "/nhan-vien/hien-thi", // GET
        "/nhan-vien/delete", // GET
        "/nhan-vien/view-update", // GET
        "/nhan-vien/update", // POST
        "/nhan-vien/add", // POST
        "/nhan-vien/phan-trang", // GET
        "/nhan-vien/search", // GET
        "/nhan-vien/sortLuong" // GET
})
public class NhanVienController extends HttpServlet {
    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    PhongBanRepository phongBanRepository = new PhongBanRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        } else if(uri.contains("phan-trang")) {
            phanTrang(req, resp);
        } else if(uri.contains("search")) {
            search(req, resp);
        } else if(uri.contains("sortLuong")) {
            sortLuong(req, resp);
        }
    }

    private void sortLuong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", nhanVienRepository.sortLuong());
        req.setAttribute("listPhongBan", phongBanRepository.getAll());
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req, resp);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        req.setAttribute("danhSach", nhanVienRepository.search(ten));
        req.setAttribute("listPhongBan", phongBanRepository.getAll());
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req, resp);
    }

    private void phanTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 0;
        int pageSize = 3;
        String pageParam = req.getParameter("page");
        if( pageParam != null && !pageParam.isEmpty()) {
            page = Integer.valueOf(pageParam);
        }
        req.setAttribute("danhSach", nhanVienRepository.phanTrang(page, pageSize));
        req.setAttribute("listPhongBan", phongBanRepository.getAll());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        nhanVienRepository.deleteNhanVien(id);
        resp.sendRedirect("/nhan-vien/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("nhanVien", nhanVienRepository.getOne(id));
        req.setAttribute("listPhongBan", phongBanRepository.getAll());
        req.getRequestDispatcher("/buoi3/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listPhongBan", phongBanRepository.getAll());
        req.setAttribute("danhSach", nhanVienRepository.getAll());
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addNhanVien(req, resp);
        } else if(uri.contains("update")) {
            updateNhanVien(req, resp);
        }
    }

    private void updateNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String hoTen = req.getParameter("hoTen");
        String chucVu = req.getParameter("chucVu");
        Float luong = Float.valueOf(req.getParameter("luong"));
        Boolean dangLamViec = Boolean.valueOf(req.getParameter("dangLamViec"));

        // Lay ra phongBan tuong ung voi idPhongBan
        Integer idPhongBan = Integer.valueOf(req.getParameter("phongBan"));
        PhongBan phongBan = phongBanRepository.getOne(idPhongBan);

        // Tao nhan vien
        NhanVien nhanVien = new NhanVien(id, hoTen, chucVu, luong, dangLamViec, phongBan);

        // Sua nhan vien trong db
        nhanVienRepository.updateNhanVien(nhanVien);

        resp.sendRedirect("/nhan-vien/hien-thi");
    }

    private void addNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String hoTen = req.getParameter("hoTen");
        String chucVu = req.getParameter("chucVu");
        Float luong = Float.valueOf(req.getParameter("luong"));
        Boolean dangLamViec = Boolean.valueOf(req.getParameter("dangLamViec"));

        // Lay ra phongBan tuong ung voi idPhongBan
        Integer idPhongBan = Integer.valueOf(req.getParameter("phongBan"));
        PhongBan phongBan = phongBanRepository.getOne(idPhongBan);

        // Tao nhan vien moi
        NhanVien nhanVien = new NhanVien(null, hoTen, chucVu, luong, dangLamViec, phongBan);

        // Them nhan vien vao db
        nhanVienRepository.addNhanVien(nhanVien);

        resp.sendRedirect("/nhan-vien/hien-thi");
    }
}
