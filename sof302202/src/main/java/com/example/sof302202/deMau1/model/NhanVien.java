package com.example.sof302202.deMau1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//id INT IDENTITY(1,1) PRIMARY KEY,
//        ma_nhan_vien NVARCHAR(20)  ,
//        ho_ten NVARCHAR(255)  ,
//        gioi_tinh BIT,
//        so_dien_thoai VARCHAR(15),
@Entity
@Table(name = "nhan_vien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_nhan_vien")
    private String maNhanVien;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @ManyToOne
    @JoinColumn(name = "id_chuc_vu", referencedColumnName = "id")
    private ChucVu chucVu;
}
