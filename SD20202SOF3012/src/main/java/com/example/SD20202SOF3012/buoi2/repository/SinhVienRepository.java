package com.example.SD20202SOF3012.buoi2.repository;

import com.example.SD20202SOF3012.buoi2.model.SinhVien;
import com.example.SD20202SOF3012.buoi2.util.HibernateConfig;
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

    public SinhVien getOne(Integer id) {
        return session.find(SinhVien.class, id);
    }

    public void themSinhVien(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.save(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void suaSinhVien(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.merge(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoaSinhVien(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getOne(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
