package com.example.service;

import com.example.model.pojo.Gudang;
import com.example.wrapper.DataResponse;
import com.example.wrapper.ListResponse;
import com.example.wrapper.DefaultResponse;

public interface GudangService {
    DataResponse<Gudang> findById(Long id);
    ListResponse<Gudang> findAll();
    ListResponse<Gudang> findByKodeKantor(String kodeKantor);
    DataResponse<Gudang> create(Gudang gudang);
    DataResponse<Gudang> update(Long id, Gudang gudang);
    DefaultResponse delete(Long id);
} 