-- Tabel KANTOR
CREATE TABLE kantor (
    id SERIAL PRIMARY KEY,
    kode_kantor VARCHAR(20) NOT NULL UNIQUE,
    nama_kantor VARCHAR(100) NOT NULL,
    waktu_rekam TIMESTAMP NOT NULL,
    waktu_update TIMESTAMP NOT NULL
);

-- Tabel GUDANG
CREATE TABLE gudang (
    id SERIAL PRIMARY KEY,
    kode_gudang VARCHAR(20) NOT NULL UNIQUE,
    nama_gudang VARCHAR(100) NOT NULL,
    kode_kantor VARCHAR(20) NOT NULL,
    waktu_rekam TIMESTAMP NOT NULL,
    waktu_update TIMESTAMP NOT NULL,
    CONSTRAINT fk_gudang_kantor FOREIGN KEY (kode_kantor) REFERENCES kantor(kode_kantor)
);

-- Tabel KONTAINER
CREATE TABLE kontainer (
    id SERIAL PRIMARY KEY,
    nomor_kontainer VARCHAR(30) NOT NULL UNIQUE,
    kode_gudang VARCHAR(20) NOT NULL,
    kode_kantor VARCHAR(20) NOT NULL,
    nomor_dokumen VARCHAR(50) NOT NULL,
    waktu_rekam TIMESTAMP NOT NULL,
    waktu_update TIMESTAMP NOT NULL,
    CONSTRAINT fk_kontainer_gudang FOREIGN KEY (kode_gudang) REFERENCES gudang(kode_gudang),
    CONSTRAINT fk_kontainer_kantor FOREIGN KEY (kode_kantor) REFERENCES kantor(kode_kantor)
); 