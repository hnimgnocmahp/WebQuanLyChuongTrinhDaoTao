package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CtdtUserRepository extends JpaRepository<CtdtUser, Integer> {
    Optional<CtdtUser> findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByUsernameAndIdNot(String username, Integer id);
}