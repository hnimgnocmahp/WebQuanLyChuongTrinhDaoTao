package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.DeCuongChiTiet;
import org.quanlychuongtrinhdaotao.repository.DeCuongChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeCuongChiTietService {

    @Autowired
    private DeCuongChiTietRepository repository;

    public List<DeCuongChiTiet> getAll() {
        return repository.findAll();
    }

    public DeCuongChiTiet getById(int id) {
        Optional<DeCuongChiTiet> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public DeCuongChiTiet save(DeCuongChiTiet obj) {
        return repository.save(obj);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
