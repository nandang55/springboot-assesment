package com.example.model.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class GudangRequest {
    @NotNull
    @Size(max = 20)
    private String kodeGudang;

    @NotNull
    @Size(max = 100)
    private String namaGudang;

    @NotNull
    private Long kantorId;
} 