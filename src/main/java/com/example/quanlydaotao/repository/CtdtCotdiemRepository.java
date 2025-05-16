package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtCotdiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtdtCotdiemRepository extends JpaRepository<CtdtCotdiem, Integer> {}