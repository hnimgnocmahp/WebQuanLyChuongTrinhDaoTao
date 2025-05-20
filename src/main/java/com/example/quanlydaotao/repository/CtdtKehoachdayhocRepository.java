package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtKehoachdayhoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtdtKehoachdayhocRepository extends JpaRepository<CtdtKehoachdayhoc, Integer> {
    List<CtdtKehoachdayhoc> findByHocPhanId(Integer hocPhanId);
}