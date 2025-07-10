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

    public NuocHoa chiTiet(Integer id) {
        return session.find(NuocHoa.class, id);
    }

    public void them(NuocHoa nuocHoa) {
        try {
            session.getTransaction().begin();
            session.save(nuocHoa);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
