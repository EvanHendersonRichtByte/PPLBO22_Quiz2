--hapus tabel jika ada
DROP TABLE IF EXISTS nilai;
DROP TABLE IF EXISTS data_nilai;
DROP TABLE IF EXISTS matkul;
DROP TABLE IF EXISTS mahasiswa;
DROP TABLE IF EXISTS kelas;
---------------------------------

--membuat tabel
CREATE TABLE kelas (
    id_kelas INT AUTO_INCREMENT PRIMARY KEY,
    nama_kelas VARCHAR(20) NOT NULL
);

CREATE TABLE mahasiswa (
    nim VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    no_presensi CHAR(2) NOT NULL,
    id_kelas INT NOT NULL,
    FOREIGN KEY(id_kelas) REFERENCES kelas(id_kelas)
);

CREATE TABLE matkul (
    id_matkul INT AUTO_INCREMENT PRIMARY KEY,
    nama_matkul VARCHAR(255) NOT NULL
);

CREATE TABLE data_nilai(
    id_data_nilai INT AUTO_INCREMENT PRIMARY KEY,
    nim VARCHAR(10) NOT NULL,
    id_matkul INT NOT NULL,
    tugas1 DECIMAL(5, 2) DEFAULT 0,
    tugas2 DECIMAL(5, 2) DEFAULT 0,
    tugas3 DECIMAL(5, 2) DEFAULT 0,
    tugas4 DECIMAL(5, 2) DEFAULT 0,
    tugas5 DECIMAL(5, 2) DEFAULT 0,
    quiz1 DECIMAL(5, 2) DEFAULT 0,
    quiz2 DECIMAL(5, 2) DEFAULT 0,
    uts DECIMAL(5, 2) DEFAULT 0,
    uas DECIMAL(5, 2) DEFAULT 0,
    total_nilai DECIMAL(5, 2) 
    AS (((tugas1+tugas2+tugas3+tugas4+tugas5)*0.02)+
        ((quiz1+quiz2)*0.1)+
        ((uts)*0.35)+
        ((uas)*0.35)),
    FOREIGN KEY (nim) REFERENCES mahasiswa (nim),
    FOREIGN KEY(id_matkul) REFERENCES matkul(id_matkul)
);

CREATE TABLE nilai (
    id_nilai INT AUTO_INCREMENT PRIMARY KEY,
    nim VARCHAR(10) NOT NULL,
    id_matkul INT NOT NULL,
    nilai INT NOT NULL,
    FOREIGN KEY(nim) REFERENCES mahasiswa(nim),
    FOREIGN KEY(id_matkul) REFERENCES matkul(id_matkul),
    FOREIGN KEY(nilai) REFERENCES data_nilai(id_data_nilai)
);
-----------------------------------------------------------------

--tambah data setiap tabel
INSERT INTO kelas (nama_kelas) VALUES 
    ('1A'), 
    ('1B'), 
    ('1C')
;

INSERT INTO mahasiswa (no_presensi, nim, nama, id_kelas) VALUES 
    (4, 2131710082, 'ARIELIA ZAHWA', 1), 
    (10, 2131710071, 'DIVA GRACIA SALMANTA CANDRA', 1), 
    (13, 2131710136, 'GALUR ARASY LUMINTANG', 1), 
    (14, 2131710073, 'IBNU TSALIS ASSALAM', 1), 
    (15, 2131710022, 'INDIRA IRAWATI PUTRI', 1)
;

INSERT INTO matkul (nama_matkul) VALUES 
    ('Dasar Pemrograman'), 
    ('Desain Web'), 
    ('Struktur Data'), 
    ('Basis Data')
;

INSERT INTO data_nilai VALUES 
    (NULL, '2131710082', 1, 90, 89, 93, 100, 90, 89, 88, 90, 93, NULL),
    (NULL, '2131710071', 1, 90, 85, 93, 97, 90, 100, 89, 90, 93, NULL),
    (NULL, '2131710136', 1, 90, 87, 93, 100, 90, 100, 90, 100, 100, NULL),
    (NULL, '2131710073', 1, 90, 85, 93, 93, 90, 98, 91, 90, 93, NULL),
    (NULL, '2131710022', 1, 90, 87, 93, 93, 90, 89, 92, 90, 93, NULL)
;

INSERT INTO nilai (nim, id_matkul, nilai) VALUES 
    (2131710082, 1, 1), 
    (2131710071, 1, 2), 
    (2131710136, 1, 3), 
    (2131710073, 1, 4),
    (2131710022, 1, 5)
;
----------------------------------------------------------------------------

--GOOD QUESTION :|
SELECT mahasiswa.nim AS 'NIM',
    nama_kelas AS 'Kelas', 
    nama AS 'Nama', 
    nama_matkul AS 'Mata Kuliah', 
    total_nilai AS 'Nilai'  FROM nilai 
    JOIN matkul ON nilai.id_matkul = matkul.id_matkul 
    JOIN mahasiswa ON nilai.nim = mahasiswa.nim 
    JOIN kelas ON mahasiswa.id_kelas = kelas.id_kelas
    JOIN data_nilai ON nilai.nilai = data_nilai.id_data_nilai
;
----------------------------------------------------------------