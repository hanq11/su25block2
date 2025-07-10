package com.example.botucsof3012.buoi2.controller;

import com.example.botucsof3012.buoi2.model.NuocHoa;
import com.example.botucsof3012.buoi2.repository.NuocHoaRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "nuocHoaController", value = {
        "/buoi2/hien-thi", // GET
        "/buoi2/them", // POST
        "/buoi2/chi-tiet" // GET
})
public class NuocHoaController extends HttpServlet {
    NuocHoaRepository nhRepo = new NuocHoaRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("chi-tiet")) {
            chiTiet(req, resp);
        }
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("nuocHoa", nhRepo.chiTiet(id));
        req.getRequestDispatcher("/buoi2/chiTiet.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", nhRepo.getAll());
        req.getRequestDispatcher("/buoi2/hienThi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themNuocHoa(req, resp);
        }
    }

    private void themNuocHoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Float gia = Float.valueOf(req.getParameter("gia"));

        NuocHoa nh = new NuocHoa(null, ten, soLuong, gia);
        nhRepo.them(nh);
        resp.sendRedirect("/buoi2/hien-thi");
    }
}


















