package com.example.quanlydaotao.service;

import com.example.quanlydaotao.repository.CtdtGiangvienRepository;
import com.example.quanlydaotao.repository.CtdtHocphanRepository;
import com.example.quanlydaotao.repository.CtdtKehoachdayhocRepository;
import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.entity.CtdtKehoachdayhoc;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class KeHoachDayHocService {
    CtdtKehoachdayhocRepository repo;
    CtdtHocphanRepository hocphanRepository;
    CtdtGiangvienRepository giangvienRepository;
    

    public KeHoachDayHocService(CtdtKehoachdayhocRepository repo, CtdtHocphanRepository hocphanRepository, CtdtGiangvienRepository giangvienRepository) {
        this.repo = repo;
        this.hocphanRepository = hocphanRepository;
        this.giangvienRepository = giangvienRepository;
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
