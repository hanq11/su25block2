package com.example.tutorsof3012.buoi1.repository;

import com.example.tutorsof3012.buoi1.model.SanPham;
import com.example.tutorsof3012.buoi1.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SanPhamRepository {
    private Session session = null;

    public SanPhamRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SanPham> getAll() {
        return session.createQuery("FROM SanPham").list(); // JPQL -> huong den class
    }

    public void addSanPham(SanPham sanPham) {
        try {
            session.getTransaction().begin();
            session.save(sanPham);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public SanPham getOne(Integer id) {
        return session.find(SanPham.class, id);
    }

    public void updateSanPham(SanPham sanPham) {
        try {
            session.getTransaction().begin();
            session.merge(sanPham);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteSanPham(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getOne(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<SanPham> searchByTen(String tenSanPham) {
        Query query = session.createQuery("FROM SanPham sp WHERE sp.tenSanPham LIKE :ten");
        query.setParameter("ten", "%" + tenSanPham + "%");
        return query.list();
    }

    public List<SanPham> sortByNhaSanXuat() {
        Query query = session.createQuery("FROM SanPham sp ORDER BY sp.nhaSanXuat");
        return query.list();
    }
}
