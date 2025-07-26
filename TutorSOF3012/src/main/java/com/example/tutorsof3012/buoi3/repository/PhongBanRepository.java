package com.example.tutorsof3012.buoi3.repository;

import com.example.tutorsof3012.buoi3.model.NhanVien;
import com.example.tutorsof3012.buoi3.model.PhongBan;
import com.example.tutorsof3012.buoi3.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class PhongBanRepository {
    private Session session = null;

    public PhongBanRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<PhongBan> getAll() {
        return session.createQuery("FROM PhongBan").list();
    }

    public PhongBan getOne(Integer id) {
        return session.find(PhongBan.class, id);
    }
}
