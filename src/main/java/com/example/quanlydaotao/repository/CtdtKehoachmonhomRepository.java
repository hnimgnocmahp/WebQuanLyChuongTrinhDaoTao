package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtKehoachmonhom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CtdtKehoachmonhomRepository extends JpaRepository<CtdtKehoachmonhom, Integer> {
    List<CtdtKehoachmonhom> findByThoiGianBatDauLessThanEqualAndThoiGianKetThucGreaterThanEqual(
            LocalDate from,
            LocalDate to
    );

    List<CtdtKehoachmonhom> findByHocPhanId(Integer id);

    long countByHocPhanId(Integer hocPhanId);

    @Query("""
      SELECT DISTINCT g
      FROM CtdtKehoachmonhom g
        JOIN FETCH g.hocPhan hp
        JOIN FETCH g.assignments a
        JOIN FETCH a.giangVien gv
        ORDER BY g.maNhom ASC
      """)
    List<CtdtKehoachmonhom> findActiveWithAll();
}