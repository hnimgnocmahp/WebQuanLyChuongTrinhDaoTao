package com.example.quanlydaotao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.quanlydaotao.entity.CtdtKhungchuongtrinhNhomkienthuc;
import com.example.quanlydaotao.repository.CtdtKhungchuongtrinhNhomkienthucRepository;

@Service
public class KhungChuongTrinhNhomKienThucService {

    CtdtKhungchuongtrinhNhomkienthucRepository repository;


    public KhungChuongTrinhNhomKienThucService(CtdtKhungchuongtrinhNhomkienthucRepository repository) {
        this.repository = repository;
    }

    public List<CtdtKhungchuongtrinhNhomkienthuc> findAll(){
        return repository.findAll();
    }

    public List<CtdtKhungchuongtrinhNhomkienthuc> findByIdKhungchuongtrinh(Integer id){
        return repository.findByIdKhungchuongtrinh(id);
    };


    public CtdtKhungchuongtrinhNhomkienthuc save(CtdtKhungchuongtrinhNhomkienthuc khungchuongtrinhNhomkienthuc){
        return repository.save(khungchuongtrinhNhomkienthuc);
    };
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Optional<CtdtKhungchuongtrinhNhomkienthuc> findByid(Integer id){
        return repository.findById(id);
    }

    public Optional<CtdtKhungchuongtrinhNhomkienthuc> findByIdKhungchuongtrinhAndIdManhom(Integer kctId, Integer nhomId){
        return repository.findByIdKhungchuongtrinhAndIdManhom(kctId, nhomId);
    };

}