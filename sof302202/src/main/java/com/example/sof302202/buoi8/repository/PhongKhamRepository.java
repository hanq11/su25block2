package com.example.sof302202.buoi8.repository;

import com.example.sof302202.buoi8.model.PhongKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhongKhamRepository extends JpaRepository<PhongKham, Integer> {
}
