package com.example.tutorsof3012.buoi1.repository;

import com.example.tutorsof3012.buoi1.model.SanPham;
import com.example.tutorsof3012.buoi1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepository {
    private Session session = null;

    public SanPhamRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SanPham> getAll() {
        return session.createQuery("FROM SanPham").list(); // JPQL -> huong den class
    }
}
