package com.example.model.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class KontainerRequest {
    @NotNull
    @Size(max = 100)
    private String namaKontainer;

    @NotNull
    private Long gudangId;

    @NotNull
    @Size(max = 30)
    private String kodeKontainer;
} 