package com.example.tutorsof3012.buoi1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "nha_san_xuat")
    private String nhaSanXuat;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "con_hang")
    private Boolean conHang;
}
