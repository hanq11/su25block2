package com.example.SD20205.buoi7.repository;

import com.example.SD20205.buoi7.model.Sach;
import com.example.SD20205.buoi7.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SachRepository {
    private Session session = null;

    public SachRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<Sach> getAll() {
        return session.createQuery("FROM Sach").list();
    }
}
