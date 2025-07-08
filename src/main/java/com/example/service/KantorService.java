package com.example.service;

import com.example.model.pojo.Kantor;
import com.example.wrapper.DataResponse;
import com.example.wrapper.ListResponse;
import com.example.wrapper.DefaultResponse;

public interface KantorService {
    DataResponse<Kantor> findById(Long id);
    ListResponse<Kantor> findAll();
    DataResponse<Kantor> create(Kantor kantor);
    DataResponse<Kantor> update(Long id, Kantor kantor);
    DefaultResponse delete(Long id);
} 