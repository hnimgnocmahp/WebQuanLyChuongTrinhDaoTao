package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtCotdiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtdtCotdiemRepository extends JpaRepository<CtdtCotdiem, Integer> {
    List<CtdtCotdiem> findByDecuongId(Integer decuongId);
}