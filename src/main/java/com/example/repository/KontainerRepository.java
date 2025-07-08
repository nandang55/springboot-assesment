package com.example.repository;

import com.example.model.pojo.Kontainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KontainerRepository extends JpaRepository<Kontainer, Long> {
    Kontainer findByKodeKontainer(String kodeKontainer);
    List<Kontainer> findByGudang_Id(Long gudangId);
} 