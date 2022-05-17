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
CREATE TABLE nilai (
    id_nilai INT AUTO_INCREMENT PRIMARY KEY,
    nim VARCHAR(10) NOT NULL,
    id_matkul INT NOT NULL,
    nilai DECIMAL(5, 2) NOT NULL,
    FOREIGN KEY(nim) REFERENCES mahasiswa(nim),
    FOREIGN KEY(id_matkul) REFERENCES matkul(id_matkul)
);
INSERT INTO kelas VALUES (NULL, '1A'), (NULL, '1B'), (NULL, '1C');

INSERT INTO mahasiswa (no_presensi, nim, nama, id_kelas)
VALUES (4, 2131710082, 'ARIELIA ZAHWA', 1), (10, 2131710071, 'DIVA GRACIA SALMANTA CANDRA', 1), (13, 2131710136, 'GALUR ARASY LUMINTANG', 1), (14, 2131710073, 'IBNU TSALIS ASSALAM', 1), (15, 2131710022, 'INDIRA IRAWATI PUTRI', 1);

INSERT INTO matkul 
VALUES (NULL, 'Dasar Pemrograman'), (NULL, 'Desain Web'), (NULL, 'Struktur Data'), (NULL, 'Basis Data');

INSERT INTO nilai 
VALUES (NULL, 2131710082, 1, 85.70), (NULL, 2131710071, 1, 100), (NULL, 2131710136, 1, 90.50), (NULL, 2131710073, 1, 95.40);

SELECT mahasiswa.nim AS 'NIM',nama_kelas AS 'Kelas', nama AS 'Nama', nama_matkul AS 'Mata Kuliah', nilai AS 'Nilai'  FROM nilai JOIN matkul ON nilai.id_matkul = matkul.id_matkul JOIN mahasiswa ON nilai.nim = mahasiswa.nim JOIN kelas ON mahasiswa.id_kelas = kelas.id_kelas;