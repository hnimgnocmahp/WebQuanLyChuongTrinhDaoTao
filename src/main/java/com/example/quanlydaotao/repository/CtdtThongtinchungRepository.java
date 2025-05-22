package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtThongtinchung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CtdtThongtinchungRepository extends JpaRepository<CtdtThongtinchung, Integer> {
    Optional<CtdtThongtinchung> findByMaCtdt(String maCtdt);
}