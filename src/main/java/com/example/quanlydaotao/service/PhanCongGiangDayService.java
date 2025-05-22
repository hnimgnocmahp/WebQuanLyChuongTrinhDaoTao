package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.CtdtPhanconggiangday;
import com.example.quanlydaotao.repository.CtdtPhanconggiangdayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhanCongGiangDayService {
    private final CtdtPhanconggiangdayRepository repo;
    public PhanCongGiangDayService(CtdtPhanconggiangdayRepository repo) {
        this.repo = repo;
    }
    public List<CtdtPhanconggiangday> findByGroupId(Integer nhomId) {
        return repo.findByNhomId(nhomId);
    }
    
    public void deleteById(Integer id) { repo.deleteById(id); }
 
}