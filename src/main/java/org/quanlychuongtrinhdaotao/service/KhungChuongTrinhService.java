package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.KhungChuongTrinh;
import org.quanlychuongtrinhdaotao.repository.KhungChuongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhungChuongTrinhService {
    private final KhungChuongTrinhRepository khungChuongTrinhRepository;

    @Autowired
    public KhungChuongTrinhService(KhungChuongTrinhRepository khungChuongTrinhRepository){
        this.khungChuongTrinhRepository = khungChuongTrinhRepository;
    }

    public KhungChuongTrinh createKhungChuongTrinh(KhungChuongTrinh khungChuongTrinh){
        return khungChuongTrinhRepository.save(khungChuongTrinh);
    }

    public KhungChuongTrinh getKhungChuongTrinhByID(int id){
        return khungChuongTrinhRepository.findById(id).orElse(null);
    }

    public List<KhungChuongTrinh> getAllKhungChuongTrinh(){
        return khungChuongTrinhRepository.findAll();
    }

    public boolean deleteKhungChuongTrinh (int id){
        if(khungChuongTrinhRepository.existsById(id)){
            khungChuongTrinhRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    public KhungChuongTrinh updateKhungChuongTrinh(int id,KhungChuongTrinh UpdatekhungChuongTrinh){
        KhungChuongTrinh existKhungChuongTrinh = khungChuongTrinhRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist" + id));
        existKhungChuongTrinh.setChuongTrinhDaoTao(UpdatekhungChuongTrinh.getChuongTrinhDaoTao());
        existKhungChuongTrinh.setKhoiKenThuc(UpdatekhungChuongTrinh.getKhoiKenThuc());
        existKhungChuongTrinh.setSoTinChi(UpdatekhungChuongTrinh.getSoTinChi());

        return khungChuongTrinhRepository.save(existKhungChuongTrinh);
    }
}
