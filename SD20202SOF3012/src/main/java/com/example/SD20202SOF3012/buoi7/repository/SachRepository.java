package com.example.SD20202SOF3012.buoi7.repository;

import com.example.SD20202SOF3012.buoi7.model.Sach;
import com.example.SD20202SOF3012.buoi7.util.HibernateConfig;
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

    public Sach getOne(Integer id) {
        return session.find(Sach.class, id);
    }
    public void addSach(Sach sach) {
        try {
            session.getTransaction().begin();
            session.save(sach);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void updateSach(Sach sach) {
        try {
            session.getTransaction().begin();
            session.merge(sach);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void deleteSach(Integer id) {
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
