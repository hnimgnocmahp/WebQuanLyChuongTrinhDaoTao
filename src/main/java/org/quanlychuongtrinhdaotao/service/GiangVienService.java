package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.GiangVien;
import org.quanlychuongtrinhdaotao.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiangVienService {
    private final GiangVienRepository giangVienRepository;

    @Autowired
    public GiangVienService(GiangVienRepository giangVienRepository){
        this.giangVienRepository = giangVienRepository;
    }

    public GiangVien createGiangVien(GiangVien giangVien){
        return giangVienRepository.save(giangVien);
    }

    public GiangVien getGiangVienById(int id){
        return giangVienRepository.findById(id).orElse(null);
    }

    public List<GiangVien> getAllGiangVien(){
        return giangVienRepository.findAll();
    }

    public boolean deleteGiangVien(int id){
        if (giangVienRepository.existsById(id)){
            giangVienRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    public GiangVien updateGiangVien(int id, GiangVien updateGiangVien){
        Optional <GiangVien> existGiangVien = giangVienRepository.findById(id);
        if (existGiangVien.isPresent()){
            GiangVien giangVien = existGiangVien.get();
            giangVien.setHocVi(updateGiangVien.getHocVi());
            giangVien.setMaCB(updateGiangVien.getMaCB());
            giangVien.setHoTen(updateGiangVien.getHoTen());
            giangVien.setNamSinh(updateGiangVien.getNamSinh());

            return giangVienRepository.save(giangVien);
        }
        else {
            return null;
        }
    }
}
