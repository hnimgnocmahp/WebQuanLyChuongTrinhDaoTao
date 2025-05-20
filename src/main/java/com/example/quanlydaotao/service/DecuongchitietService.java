package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.CtdtDecuongchitiet;
import com.example.quanlydaotao.repository.CtdtDecuongchitietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecuongchitietService {
    private final CtdtDecuongchitietRepository repository;

    @Autowired
    public DecuongchitietService(CtdtDecuongchitietRepository repository) {
        this.repository = repository;
    }

    public List<CtdtDecuongchitiet> findAll() {
        return repository.findAll();
    }

    public CtdtDecuongchitiet findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public CtdtDecuongchitiet save(CtdtDecuongchitiet decuongchitiet) {
        return repository.save(decuongchitiet);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public CtdtDecuongchitiet findByHocPhanId(Integer hocPhanId) {
        return repository.findByHocPhanId(hocPhanId);
    }
} 