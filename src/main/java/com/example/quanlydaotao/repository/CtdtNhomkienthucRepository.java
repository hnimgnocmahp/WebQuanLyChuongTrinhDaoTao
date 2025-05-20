package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.entity.CtdtNhomkienthuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CtdtNhomkienthucRepository extends JpaRepository<CtdtNhomkienthuc, Integer> {
    Optional<CtdtNhomkienthuc> findByManhom(String Manhom);
}