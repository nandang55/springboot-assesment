package com.example.model.pojo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Entity
@Table(name = "kantor")
public class Kantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "kode_kantor", nullable = false, unique = true)
    private String kodeKantor;

    @NotNull
    @Size(max = 100)
    @Column(name = "nama_kantor", nullable = false)
    private String namaKantor;

    @Column(name = "waktu_rekam", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private java.time.LocalDateTime waktuRekam;

    @Column(name = "waktu_update", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private java.time.LocalDateTime waktuUpdate;
} 