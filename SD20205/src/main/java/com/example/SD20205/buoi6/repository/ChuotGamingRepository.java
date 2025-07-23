package com.example.SD20205.buoi6.repository;

import com.example.SD20205.buoi6.model.ChuotGaming;
import com.example.SD20205.buoi6.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ChuotGamingRepository {
    private Session session = null;

    public ChuotGamingRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<ChuotGaming> getAll() {
        return session.createQuery("FROM ChuotGaming").list();
    }

    public ChuotGaming getOne(Integer id) {
        return session.find(ChuotGaming.class, id);
    }

    public void addChuot(ChuotGaming chuotGaming) {
        try {
            session.getTransaction().begin();
            session.save(chuotGaming);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void updateChuot(ChuotGaming chuotGaming) {
        try {
            session.getTransaction().begin();
            session.merge(chuotGaming);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteChuot(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getOne(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<ChuotGaming> phanTrang(int page) {
        int pageSize = 2;
        Query query = session.createQuery("FROM ChuotGaming ");
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

    public List<ChuotGaming> searchByTen(String ten) {
        Query query = session.createQuery("FROM ChuotGaming cg WHERE cg.ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        return query.list();
    }

    public List<ChuotGaming> sortByGia() {
        return session.createQuery("FROM ChuotGaming cg ORDER BY cg.gia").list();
    }
}
