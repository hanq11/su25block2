package com.example.tutorsof3012.demoAjax;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ajaxController", value = {
        "/api/ajax/demo"
})
public class AjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SinhVien sv = new SinhVien("PH1234", "Nguyen Van A", 19);
        // Chuyen object -> json
        Gson gson = new Gson();
        String data = gson.toJson(sv);

        // Dat kieu tra ve la json
        resp.setContentType("application/json");

        // Day ket qua ve cho client
        PrintWriter pw = resp.getWriter();
        pw.println(data);
        pw.flush();
    }
}
