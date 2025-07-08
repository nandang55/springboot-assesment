package com.example.service.impl;

import com.example.model.pojo.Kantor;
import com.example.repository.KantorRepository;
import com.example.service.KantorService;
import com.example.wrapper.DataResponse;
import com.example.wrapper.ListResponse;
import com.example.wrapper.DefaultResponse;
import com.example.exception.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Service
public class KantorServiceImpl implements KantorService {

    @Autowired
    private KantorRepository kantorRepository;

    @Override
    public DataResponse<Kantor> findById(Long id) {
        try {
            Kantor kantor = kantorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kantor tidak ditemukan"));
            return new DataResponse<>(kantor);
        } catch (Exception e) {
            log.error("Gagal findById Kantor", e);
            throw e;
        }
    }

    @Override
    public ListResponse<Kantor> findAll() {
        try {
            List<Kantor> list = kantorRepository.findAll();
            return new ListResponse<>(list);
        } catch (Exception e) {
            log.error("Gagal findAll Kantor", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DataResponse<Kantor> create(Kantor kantor) {
        try {
            kantor.setWaktuRekam(LocalDateTime.now());
            kantor.setWaktuUpdate(LocalDateTime.now());
            Kantor saved = kantorRepository.save(kantor);
            return new DataResponse<>(saved);
        } catch (Exception e) {
            log.error("Gagal create Kantor", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DataResponse<Kantor> update(Long id, Kantor kantor) {
        try {
            Kantor existing = kantorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kantor tidak ditemukan"));
            existing.setNamaKantor(kantor.getNamaKantor());
            existing.setWaktuUpdate(LocalDateTime.now());
            Kantor updated = kantorRepository.save(existing);
            return new DataResponse<>(updated);
        } catch (Exception e) {
            log.error("Gagal update Kantor", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DefaultResponse delete(Long id) {
        try {
            Kantor existing = kantorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kantor tidak ditemukan"));
            kantorRepository.delete(existing);
            return new DefaultResponse("Berhasil hapus kantor");
        } catch (Exception e) {
            log.error("Gagal delete Kantor", e);
            throw e;
        }
    }
} 