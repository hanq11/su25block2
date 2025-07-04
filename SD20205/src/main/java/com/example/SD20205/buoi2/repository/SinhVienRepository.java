package com.example.SD20205.buoi2.repository;

import com.example.SD20205.buoi2.model.SinhVien;
import com.example.SD20205.buoi2.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    private Session session = null;

    public SinhVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        return session.createQuery("FROM SinhVien").list();
    }
}
