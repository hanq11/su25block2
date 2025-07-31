package com.example.tutorsof3012.buoi3.repository;

import com.example.tutorsof3012.buoi3.model.NhanVien;
import com.example.tutorsof3012.buoi3.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class NhanVienRepository {
    private Session session = null;

    public NhanVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<NhanVien> getAll() {
        return session.createQuery("FROM NhanVien").list();
    }

    public void addNhanVien(NhanVien nhanVien) {
        try {
            session.getTransaction().begin();
            session.save(nhanVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public NhanVien getOne(Integer id) {
        return session.find(NhanVien.class, id);
    }

    public void updateNhanVien(NhanVien nhanVien) {
        try {
            session.getTransaction().begin();
            session.merge(nhanVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteNhanVien(Integer id) {
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
