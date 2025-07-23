package com.example.SD20202SOF3012.buoi7.repository;

import com.example.SD20202SOF3012.buoi7.model.TheLoai;
import com.example.SD20202SOF3012.buoi7.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class TheLoaiRepository {
    private Session session = null;

    public TheLoaiRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<TheLoai> getAll() {
        return session.createQuery("FROM TheLoai ").list();
    }

    public TheLoai getOne(Integer id) {
        return session.find(TheLoai.class, id);
    }
}
