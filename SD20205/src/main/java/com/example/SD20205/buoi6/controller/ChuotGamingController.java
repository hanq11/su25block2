package com.example.SD20205.buoi6.controller;

import com.example.SD20205.buoi6.model.ChuotGaming;
import com.example.SD20205.buoi6.repository.ChuotGamingRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "chuotGamingController", value = {
        "/chuot-gaming/hien-thi",
        "/chuot-gaming/view-update",
        "/chuot-gaming/update",
        "/chuot-gaming/add",
        "/chuot-gaming/delete",
        "/chuot-gaming/search",
        "/chuot-gaming/sort",
        "/chuot-gaming/phan-trang"
})
public class ChuotGamingController extends HttpServlet {
    ChuotGamingRepository chuotGamingRepository = new ChuotGamingRepository();
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
            sortByGia(req, resp);
        } else if(uri.contains("phan-trang")) {
            phanTrang(req, resp);
        }
    }

    private void phanTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 0;
        if(req.getParameter("page") != null && !req.getParameter("page").isEmpty()) {
            page = Integer.valueOf(req.getParameter("page"));
        }
        req.setAttribute("page", page);
        req.setAttribute("danhSach", chuotGamingRepository.phanTrang(page));
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req, resp);
    }

    private void sortByGia(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", chuotGamingRepository.sortByGia());
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req, resp);
    }

    private void searchByTen(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        req.setAttribute("danhSach", chuotGamingRepository.searchByTen(ten));
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        chuotGamingRepository.deleteChuot(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect("/chuot-gaming/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("chuot", chuotGamingRepository.getOne(Integer.valueOf(req.getParameter("id"))));
        req.getRequestDispatcher("/buoi6/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", chuotGamingRepository.getAll());
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addChuot(req, resp);
        } else if(uri.contains("update")) {
            updateChuot(req, resp);
        }
    }

    private void updateChuot(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        String matDoc = req.getParameter("matDoc");
        Float gia = Float.valueOf(req.getParameter("gia"));

        chuotGamingRepository.updateChuot(new ChuotGaming(id, ten, matDoc, gia));

        resp.sendRedirect("/chuot-gaming/hien-thi");
    }

    private void addChuot(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        String matDoc = req.getParameter("matDoc");
        Float gia = Float.valueOf(req.getParameter("gia"));

        chuotGamingRepository.addChuot(new ChuotGaming(null, ten, matDoc, gia));

        resp.sendRedirect("/chuot-gaming/hien-thi");
    }
}
