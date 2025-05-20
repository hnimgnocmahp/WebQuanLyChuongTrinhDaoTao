package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtGiangvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CtdtGiangvienRepository extends JpaRepository<CtdtGiangvien, Integer> {
    Optional<CtdtGiangvien> findByMaGv(String maGv);
}