package com.example.repository;

import com.example.model.pojo.Kantor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KantorRepository extends JpaRepository<Kantor, Long> {
    Kantor findByKodeKantor(String kodeKantor);
} 