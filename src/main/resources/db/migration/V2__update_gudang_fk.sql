-- Tambah kolom kantor_id ke tabel gudang
ALTER TABLE gudang ADD COLUMN kantor_id BIGINT;

-- Update kantor_id berdasarkan kode_kantor lama
UPDATE gudang g SET kantor_id = (SELECT k.id FROM kantor k WHERE k.kode_kantor = g.kode_kantor);

-- Set kolom kantor_id NOT NULL
ALTER TABLE gudang ALTER COLUMN kantor_id SET NOT NULL;

-- Tambah foreign key constraint
ALTER TABLE gudang ADD CONSTRAINT fk_gudang_kantor_id FOREIGN KEY (kantor_id) REFERENCES kantor(id);

-- Hapus kolom kode_kantor lama
ALTER TABLE gudang DROP COLUMN kode_kantor; 