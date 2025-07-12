package com.example.botucsof3012.buoi3.repository;

import com.example.botucsof3012.buoi3.model.KhachSan;
import com.example.botucsof3012.buoi3.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class KhachSanRepository {
    private Session session = null;

    public KhachSanRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    // Load combobox
    public List<KhachSan> getAllKhachSan() {
        return session.createQuery("FROM KhachSan").list();
    }

    // Them, sua thong tin Phong
    public KhachSan getKhachSan(Integer id) {
        return session.find(KhachSan.class, id);
    }
}
