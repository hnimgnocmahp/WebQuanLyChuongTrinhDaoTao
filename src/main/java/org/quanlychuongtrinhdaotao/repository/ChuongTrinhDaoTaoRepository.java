package org.quanlychuongtrinhdaotao.repository;

import org.quanlychuongtrinhdaotao.model.ChuongTrinhDaoTao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuongTrinhDaoTaoRepository extends JpaRepository<ChuongTrinhDaoTao, Integer> {
}
