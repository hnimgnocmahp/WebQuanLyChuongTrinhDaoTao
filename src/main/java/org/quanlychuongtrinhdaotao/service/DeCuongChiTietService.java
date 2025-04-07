package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.DeCuongChiTiet;
import org.quanlychuongtrinhdaotao.repository.DeCuongChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeCuongChiTietService {
    private final DeCuongChiTietRepository deCuongChiTietRepository;

    @Autowired
    public DeCuongChiTietService(DeCuongChiTietRepository deCuongChiTietRepository){
        this.deCuongChiTietRepository = deCuongChiTietRepository;
    }

    public DeCuongChiTiet createDeCuongChiTiet(DeCuongChiTiet deCuongChiTiet){
        return deCuongChiTietRepository.save(deCuongChiTiet);
    }

    public DeCuongChiTiet getDeCuongChiTietById(int id){
        return deCuongChiTietRepository.findById(id).orElse(null);
    }

    public List<DeCuongChiTiet> getAllDeCuongChiTiet(){
        return deCuongChiTietRepository.findAll();
    }

    public boolean deleteDeCuongChiTiet(int id){
        if (deCuongChiTietRepository.existsById(id)){
            deCuongChiTietRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    public DeCuongChiTiet updateDeCuongChiTiet(int id, DeCuongChiTiet updateDeCuongChiTiet){
        Optional<DeCuongChiTiet> existDeCuongChiTiet = deCuongChiTietRepository.findById(id);
        if (existDeCuongChiTiet.isPresent()){
            DeCuongChiTiet deCuongChiTiet = existDeCuongChiTiet.get();
            deCuongChiTiet.setHocPhan(updateDeCuongChiTiet.getHocPhan());
            deCuongChiTiet.setBoPhanDuocDanhGia(updateDeCuongChiTiet.getBoPhanDuocDanhGia());

            return deCuongChiTietRepository.save(deCuongChiTiet);
        }
        else {
            return null;
        }
    }
}

