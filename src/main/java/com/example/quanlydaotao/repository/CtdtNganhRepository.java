package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtCotdiem;
import com.example.quanlydaotao.entity.CtdtNganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtdtNganhRepository extends JpaRepository<CtdtNganh, Integer> {

}