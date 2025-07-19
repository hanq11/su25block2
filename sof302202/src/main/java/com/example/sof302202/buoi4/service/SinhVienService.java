package com.example.sof302202.buoi4.service;

import com.example.sof302202.buoi4.model.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinhVienService {
    private List<SinhVien> list = new ArrayList<>();

    public SinhVienService() {
        list.add(new SinhVien(1, "Nguyen Van A", 8.7f));
        list.add(new SinhVien(2, "Nguyen Van B", 9f));
        list.add(new SinhVien(3, "Nguyen Van C", 5f));
    }

    public List<SinhVien> getAll() {
        return list;
    }

    public SinhVien getDetail(Integer id) {
        SinhVien sinhVienCanTim = null;
        for(SinhVien sv : list) {
            if(sv.getId() == id) {
                sinhVienCanTim = sv;
            }
        }
        return sinhVienCanTim;
    }

    public void addSinhVien(SinhVien sinhVien) {
        list.add(sinhVien);
    }

    public void updateSinhVien(SinhVien sinhVien) {
        // Cach 1
//        list.replaceAll((sv -> sinhVien.getId() == sv.getId() ? sinhVien : sv));
        // Cach 2
        int index = -1;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == sinhVien.getId()) {
                index = i;
                break;
            }
        }
        list.set(index, sinhVien);
    }

    public void deleteSinhVien(Integer id) {
        list.removeIf(sv -> sv.getId() == id);
    }
}
