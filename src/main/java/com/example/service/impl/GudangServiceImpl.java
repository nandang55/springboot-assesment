package com.example.service.impl;

import com.example.model.pojo.Gudang;
import com.example.repository.GudangRepository;
import com.example.service.GudangService;
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
public class GudangServiceImpl implements GudangService {

    @Autowired
    private GudangRepository gudangRepository;

    @Override
    public DataResponse<Gudang> findById(Long id) {
        try {
            Gudang gudang = gudangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gudang tidak ditemukan"));
            return new DataResponse<>(gudang);
        } catch (Exception e) {
            log.error("Gagal findById Gudang", e);
            throw e;
        }
    }

    @Override
    public ListResponse<Gudang> findAll() {
        try {
            List<Gudang> list = gudangRepository.findAll();
            return new ListResponse<>(list);
        } catch (Exception e) {
            log.error("Gagal findAll Gudang", e);
            throw e;
        }
    }

    @Override
    public ListResponse<Gudang> findByKodeKantor(String kodeKantor) {
        try {
            List<Gudang> list = gudangRepository.findByKodeKantor(kodeKantor);
            return new ListResponse<>(list);
        } catch (Exception e) {
            log.error("Gagal findByKodeKantor Gudang", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DataResponse<Gudang> create(Gudang gudang) {
        try {
            gudang.setWaktuRekam(LocalDateTime.now());
            gudang.setWaktuUpdate(LocalDateTime.now());
            Gudang saved = gudangRepository.save(gudang);
            return new DataResponse<>(saved);
        } catch (Exception e) {
            log.error("Gagal create Gudang", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DataResponse<Gudang> update(Long id, Gudang gudang) {
        try {
            Gudang existing = gudangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gudang tidak ditemukan"));
            existing.setNamaGudang(gudang.getNamaGudang());
            existing.setKodeKantor(gudang.getKodeKantor());
            existing.setWaktuUpdate(LocalDateTime.now());
            Gudang updated = gudangRepository.save(existing);
            return new DataResponse<>(updated);
        } catch (Exception e) {
            log.error("Gagal update Gudang", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DefaultResponse delete(Long id) {
        try {
            Gudang existing = gudangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gudang tidak ditemukan"));
            gudangRepository.delete(existing);
            return new DefaultResponse("Berhasil hapus gudang");
        } catch (Exception e) {
            log.error("Gagal delete Gudang", e);
            throw e;
        }
    }
} 