package com.example.botucsof3012.buoi2.repository;

import com.example.botucsof3012.buoi2.model.NuocHoa;
import com.example.botucsof3012.buoi2.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class NuocHoaRepository {
    private Session session = null;

    public NuocHoaRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<NuocHoa> getAll() {
        return session.createQuery("FROM NuocHoa").list();
    }
}
