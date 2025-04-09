package org.quanlychuongtrinhdaotao.repository;

import org.quanlychuongtrinhdaotao.model.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, Integer> {

}
