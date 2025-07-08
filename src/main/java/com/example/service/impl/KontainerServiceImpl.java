package com.example.service.impl;

import com.example.model.pojo.Kontainer;
import com.example.model.pojo.Gudang;
import com.example.repository.KontainerRepository;
import com.example.repository.GudangRepository;
import com.example.service.KontainerService;
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
public class KontainerServiceImpl implements KontainerService {

    @Autowired
    private KontainerRepository kontainerRepository;
    @Autowired
    private GudangRepository gudangRepository;

    @Override
    public DataResponse<Kontainer> findById(Long id) {
        try {
            Kontainer kontainer = kontainerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kontainer tidak ditemukan"));
            return new DataResponse<>(kontainer);
        } catch (Exception e) {
            log.error("Gagal findById Kontainer", e);
            throw e;
        }
    }

    @Override
    public ListResponse<Kontainer> findAll() {
        try {
            List<Kontainer> list = kontainerRepository.findAll();
            return new ListResponse<>(list);
        } catch (Exception e) {
            log.error("Gagal findAll Kontainer", e);
            throw e;
        }
    }

    @Override
    public ListResponse<Kontainer> findByGudangId(Long gudangId) {
        try {
            List<Kontainer> list = kontainerRepository.findByGudang_Id(gudangId);
            return new ListResponse<>(list);
        } catch (Exception e) {
            log.error("Gagal findByGudangId Kontainer", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DataResponse<Kontainer> create(Kontainer kontainer, Long gudangId) {
        try {
            Gudang gudang = gudangRepository.findById(gudangId)
                .orElseThrow(() -> new NotFoundException("Gudang tidak ditemukan"));
            kontainer.setGudang(gudang);
            kontainer.setWaktuRekam(LocalDateTime.now());
            kontainer.setWaktuUpdate(LocalDateTime.now());
            Kontainer saved = kontainerRepository.save(kontainer);
            return new DataResponse<>(saved);
        } catch (Exception e) {
            log.error("Gagal create Kontainer", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DataResponse<Kontainer> update(Long id, Kontainer kontainer, Long gudangId) {
        try {
            Kontainer existing = kontainerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kontainer tidak ditemukan"));
            Gudang gudang = gudangRepository.findById(gudangId)
                .orElseThrow(() -> new NotFoundException("Gudang tidak ditemukan"));
            existing.setNamaKontainer(kontainer.getNamaKontainer());
            existing.setGudang(gudang);
            existing.setWaktuUpdate(LocalDateTime.now());
            Kontainer updated = kontainerRepository.save(existing);
            return new DataResponse<>(updated);
        } catch (Exception e) {
            log.error("Gagal update Kontainer", e);
            throw e;
        }
    }

    @Transactional
    @Override
    public DefaultResponse delete(Long id) {
        try {
            Kontainer existing = kontainerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kontainer tidak ditemukan"));
            kontainerRepository.delete(existing);
            return new DefaultResponse("Berhasil hapus kontainer");
        } catch (Exception e) {
            log.error("Gagal delete Kontainer", e);
            throw e;
        }
    }
} 