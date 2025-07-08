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
    waktu_rekam TIMESTAMP NOT NULL,
    waktu_update TIMESTAMP NOT NULL
);

-- Tabel KONTAINER
CREATE TABLE kontainer (
    id SERIAL PRIMARY KEY,
    kode_kontainer VARCHAR(30) NOT NULL UNIQUE,
    nama_kontainer VARCHAR(100) NOT NULL,
    gudang_id BIGINT NOT NULL,
    nomor_dokumen VARCHAR(50) NOT NULL,
    waktu_rekam TIMESTAMP NOT NULL,
    waktu_update TIMESTAMP NOT NULL,
    CONSTRAINT fk_kontainer_gudang_id FOREIGN KEY (gudang_id) REFERENCES gudang(id)
); 