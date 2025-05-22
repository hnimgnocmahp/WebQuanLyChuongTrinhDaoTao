package com.example.quanlydaotao.service;


import com.example.quanlydaotao.entity.CtdtGiangvien;
import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.entity.CtdtKehoachdayhoc;
import com.example.quanlydaotao.entity.CtdtKehoachmonhom;
import com.example.quanlydaotao.entity.CtdtPhanconggiangday;
import com.example.quanlydaotao.repository.CtdtGiangvienRepository;
import com.example.quanlydaotao.repository.CtdtHocphanRepository;
import com.example.quanlydaotao.repository.CtdtKehoachmonhomRepository;
import com.example.quanlydaotao.repository.CtdtPhanconggiangdayRepository;

import groovyjarjarantlr4.v4.parse.ANTLRParser.prequelConstruct_return;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class KeHoachMoNhomService {

    private final CtdtKehoachmonhomRepository repo;
    private final CtdtPhanconggiangdayRepository pcrepo;
    private final CtdtHocphanRepository hprepo;
    private final CtdtGiangvienRepository gvrepo;

    public KeHoachMoNhomService(CtdtKehoachmonhomRepository repo, CtdtPhanconggiangdayRepository pcrepo, CtdtHocphanRepository hprepo, CtdtGiangvienRepository gvrepo) {
        this.repo = repo;
        this.pcrepo = pcrepo;
        this.hprepo = hprepo;
        this.gvrepo = gvrepo;
    }

    public List<CtdtKehoachmonhom> findAll(){
        return repo.findAll();
    }
    public List<CtdtKehoachmonhom> findActiveGroups(LocalDate today) {
        return repo.findByThoiGianBatDauLessThanEqualAndThoiGianKetThucGreaterThanEqual(today, today);
    }

    public List<CtdtKehoachmonhom> getActiveFull() {
        return repo.findActiveWithAll();
    }

     public Optional<CtdtKehoachmonhom> findById(Integer id){
        return repo.findById(id);
    }

}