package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtThongtinchung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CtdtThongtinchungRepository extends JpaRepository<CtdtThongtinchung, Integer> {
    Optional<CtdtThongtinchung> findByMaCtdt(String maCtdt);
    List<CtdtThongtinchung> findByTenCtdtContainingIgnoreCaseOrMaCtdtContainingIgnoreCase(String tenCtdt, String maNganh);

}