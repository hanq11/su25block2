package com.example.sof302202.buoi10.repository;

import com.example.sof302202.buoi10.model.BaiHat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, Integer> {
}
