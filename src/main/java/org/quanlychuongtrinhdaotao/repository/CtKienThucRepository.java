package org.quanlychuongtrinhdaotao.repository;

import org.quanlychuongtrinhdaotao.model.CtKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtKienThucRepository extends JpaRepository<CtKienThuc, Integer> {
}
