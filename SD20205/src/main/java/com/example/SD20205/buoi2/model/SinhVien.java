package com.example.SD20205.buoi2.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {
    private Integer id;
    private String ten;
    private String diaChi;
    private Integer namSinh;
}
