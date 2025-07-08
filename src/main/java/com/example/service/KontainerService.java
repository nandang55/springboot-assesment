package com.example.service;

import com.example.model.pojo.Kontainer;
import com.example.model.pojo.KontainerRequest;
import com.example.wrapper.DataResponse;
import com.example.wrapper.ListResponse;
import com.example.wrapper.DefaultResponse;

public interface KontainerService {
    DataResponse<Kontainer> findById(Long id);
    ListResponse<Kontainer> findAll();
    ListResponse<Kontainer> findByGudangId(Long gudangId);
    DataResponse<Kontainer> create(KontainerRequest request);
    DataResponse<Kontainer> update(Long id, KontainerRequest request);
    DefaultResponse delete(Long id);
} 