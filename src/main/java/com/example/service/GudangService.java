package com.example.service;

import com.example.model.pojo.Gudang;
import com.example.model.pojo.GudangRequest;
import com.example.wrapper.DataResponse;
import com.example.wrapper.ListResponse;
import com.example.wrapper.DefaultResponse;

public interface GudangService {
    DataResponse<Gudang> findById(Long id);
    ListResponse<Gudang> findAll();
    ListResponse<Gudang> findByKantorId(Long kantorId);
    DataResponse<Gudang> create(GudangRequest request);
    DataResponse<Gudang> update(Long id, GudangRequest request);
    DefaultResponse delete(Long id);
} 