package com.example.repository;

import com.example.model.pojo.Gudang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GudangRepository extends JpaRepository<Gudang, Long> {
    Gudang findByKodeGudang(String kodeGudang);
    List<Gudang> findByKantor_Id(Long kantorId);
} 