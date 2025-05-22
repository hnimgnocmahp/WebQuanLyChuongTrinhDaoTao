package com.example.quanlydaotao.service;

import com.example.quanlydaotao.repository.CtdtKehoachdayhocRepository;
import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.entity.CtdtKehoachdayhoc;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class KeHoachDayHocService {
    CtdtKehoachdayhocRepository repo;
    

    public KeHoachDayHocService(CtdtKehoachdayhocRepository repo) {
        this.repo = repo;
    }

    public List<CtdtKehoachdayhoc> findAll() {
        return repo.findAll();
    }

    public Optional<CtdtKehoachdayhoc> findById(Integer id){
        return repo.findById(id);
    }

    public CtdtKehoachdayhoc save(CtdtKehoachdayhoc kehoachdayhoc){
        return repo.save(kehoachdayhoc);
    }

    public void deleteById(Integer id) { repo.deleteById(id); }


}
