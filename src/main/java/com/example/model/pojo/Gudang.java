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
@Table(name = "gudang")
public class Gudang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "kode_gudang", nullable = false, unique = true)
    private String kodeGudang;

    @NotNull
    @Size(max = 100)
    @Column(name = "nama_gudang", nullable = false)
    private String namaGudang;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kantor_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Kantor kantor;

    @Column(name = "waktu_rekam", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private java.time.LocalDateTime waktuRekam;

    @Column(name = "waktu_update", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private java.time.LocalDateTime waktuUpdate;
} 