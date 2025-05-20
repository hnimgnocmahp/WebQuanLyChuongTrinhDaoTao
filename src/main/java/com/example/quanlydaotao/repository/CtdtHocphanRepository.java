package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtHocphan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CtdtHocphanRepository extends JpaRepository<CtdtHocphan, Integer> {
    Optional<CtdtHocphan> findByMaHp(String maHp);
    boolean existsByMaHp(String maHp);
    List<CtdtHocphan> findByNhomId(Integer nhomId);

}