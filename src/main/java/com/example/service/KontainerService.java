package com.example.service;

import com.example.model.pojo.Kontainer;
import com.example.wrapper.DataResponse;
import com.example.wrapper.ListResponse;
import com.example.wrapper.DefaultResponse;

public interface KontainerService {
    DataResponse<Kontainer> findById(Long id);
    ListResponse<Kontainer> findAll();
    ListResponse<Kontainer> findByGudangId(Long gudangId);
    DataResponse<Kontainer> create(Kontainer kontainer, Long gudangId);
    DataResponse<Kontainer> update(Long id, Kontainer kontainer, Long gudangId);
    DefaultResponse delete(Long id);
} 