DROP TABLE IF EXISTS nilai;
DROP TABLE IF EXISTS mahasiswa;
DROP TABLE IF EXISTS matkul;
DROP TABLE IF EXISTS kelas;
DROP TABLE IF EXISTS dosen;

/* membuat tabel */

CREATE TABLE dosen (
    id_dosen INT AUTO_INCREMENT PRIMARY KEY,
    nama_dosen VARCHAR(50) NOT NULL
);

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
    nama_matkul VARCHAR(255) NOT NULL,
    id_dosen INT NOT NULL,
    FOREIGN KEY (id_dosen) REFERENCES dosen(id_dosen)
);

CREATE TABLE nilai(
    id_data_nilai INT AUTO_INCREMENT PRIMARY KEY,
    nim VARCHAR(10) NOT NULL,
    id_matkul INT NOT NULL,
    tugas1 DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    tugas2 DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    tugas3 DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    tugas4 DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    tugas5 DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    quiz1 DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    quiz2 DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    uts DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    uas DECIMAL(5, 2) DEFAULT 0 NOT NULL,
    total_nilai DECIMAL(5, 2) 
    AS (((tugas1+tugas2+tugas3+tugas4+tugas5)*0.02)+
        ((quiz1+quiz2)*0.1)+
        ((uts)*0.35)+
        ((uas)*0.35)),
    FOREIGN KEY (nim) REFERENCES mahasiswa (nim),
    FOREIGN KEY(id_matkul) REFERENCES matkul(id_matkul)
);

/* tambah data setiap tabel */

INSERT INTO dosen (nama_dosen) VALUES
    ('Abdul Chalim, SAg., MPd.I'),
    ('Ade Ismail'),
    ('Agung Nugroho Pramudhita ST., MT.'),
    ('Ahmadi Yuli Ananta ST., MM.'),
    ('Ane Fany Novitasari, SH.MKn.'),
    ('Annisa Puspa Kirana MKom.'),
    ('Annisa Taufika Firdausi ST., MT.'),
    ('Anugrah Nur Rahmanto SSn., MDs.'),
    ('Ariadi Retno Ririd SKom., MKom.'),
    ('Arie Rachmad Syulistyo SKom., MKom.'),
    ('Arief Prasetyo SKom., MKom.'),
    ('Arwin Sumari ST., MT., DR.'),
    ('Atiqah Nurul Asri SPd., MPd.'),
    ('Bagas Satya Dian Nugraha, ST., MT.'),
    ('Banni Satria Andoko, S. Kom., M.MSI'),
    ('Budi Harijanto ST., MMKom.'),
    ('Cahya Rahmad ST., MKom. DR.Eng'),
    ('Candra Bella Vista SKom., MT.'),
    ('Candrasena Setiadi ST., MMT.'),
    ('Deasy Sandhya Elya Ikawati SSi., MSi.'),
    ('Deddy Kusbianto PA Ir. MMKom.'),
    ('Dhebys Suryani SKom. MT.'),
    ('Dian Hanifudin Subhi SKom., MT.'),
    ('Dika Rizky Yunianto SKom., MKom.'),
    ('Dimas Wahyu Wibowo ST., MT.'),
    ('Dodit Supriyanto SKom., MT.'),
    ('Dwi Puspitasari SKom., MKom.'),
    ('Eka Larasati Amalia, SST., MT.'),
    ('Ekojono, ST., M.Kom.'),
    ('Elok Nur Hamdana, ST., MT'),
    ('Erfan Rohadi, ST., MEng., PhD.'),
    ('Faiz Ushbah Mubarok, SPd., MPd.'),
    ('Farid Angga Pribadi, SKom.,MKom.'),
    ('Farida Ulfa, SPd., MPd.'),
    ('Gunawan Budi Prasetyo, ST., MMT., Ph.D.'),
    ('Habibie Ed Dien, MT.'),
    ('Hairus'),
    ('Hendra Pradibta, SE., M.Sc.'),
    ('Ika Kusumaning Putri, MT.'),
    ('Imam Fahrur Rozi, ST., MT.'),
    ('Indra Dharma Wijaya, ST., MMT.'),
    ('Irsyad Arif Mashudi, M.Kom'),
    ('Kadek Suarjuna Batubulan, SKom, MT.'),
    ('Luqman Affandi, SKom., MMSI.'),
    ('M. Hasyim Ratsanjani'),
    ('Mamluatul Haniah'),
    ('Meyti Eka Apriyani ST., MT.'),
    ('Milyun Nima Shoumi'),
    ('Moch. Zawaruddin Abdullah, S.ST., M.Kom'),
    ('Moh. Amin'),
    ('Muhammad Afif Hendrawan, S.Kom.'),
    ('Muhammad Shulhan Khairy, SKom., MKom.'),
    ('Muhammad Unggul Pamenang, SSt., MT.'),
    ('Mungki Astiningrum, ST., MKom.'),
    ('Mustika Mentari, SKom., MKom.'),
    ('Noprianto'),
    ('Odhitya Desta Triswidrananta, SPd., MPd.'),
    ('Pramana Yoga Saputra, SKom., MMT.'),
    ('Putra Prima A., ST., MKom.'),
    ('Rakhmat Arianto SST., MKom.'),
    ('Rawansyah., Drs., MPd.'),
    ('Retno Damayanti, SPd.'),
    ('Ridwan Rismanto, SST., MKom.'),
    ('Rizki Putri Ramadhani, S.S., M.Pd.'),
    ('Rizky Ardiansyah, SKom., MT.'),
    ('Robby Anggriawan SE., ME.'),
    ('Rokhimatul Wakhidah SPd. MT.'),
    ('Rosa Andrie Asmara, ST., MT., Dr. Eng.'),
    ('Rudy Ariyanto, ST., MCs.'),
    ('Satrio Binusa S, SS, M.Pd'),
    ('Septian Enggar Sukmana, SPd., MT.'),
    ('Shohib Muslim'),
    ('Siti Romlah, Dra., M.M.'),
    ('Sofyan Noor Arief, S.ST., M.Kom.'),
    ('Ulla Delfiana Rosiani, ST., MT.'),
    ('Usman Nurhasan, S.Kom., MT.'),
    ('Very Sugiarto, SPd., MKom.'),
    ('Vipkas Al Hadid Firdaus, ST.,MT.'),
    ('Vivi Nur Wijayaningrum, S.Kom, M.Kom'),
    ('Vivin Ayu Lestari, SPd.'),
    ('Widaningsih Condrowardhani, SH., MH.'),
    ('Wilda Imama Sabilla, S.Kom., M.Kom.'),
    ('Yoppy Yunhasnawa, SST., MSc.'),
    ('Yuri Ariyanto, SKom., MKom.'),
    ('Zulmy Faqihuddin Putera, S.Pd., M.Pd'),
    ('Yan Watequlis Syaifudin, S.T., M.MT., Ph.D.');

INSERT INTO kelas (nama_kelas) VALUES 
    ("MI-1A"),
    ("MI-1B"),
    ("MI-1C"),
    ("MI-1D"),
    ("MI-1E"),
    ("MI-1F"),
    ("MI-1H");

INSERT INTO mahasiswa (no_presensi, nim, nama, id_kelas) VALUES 
    (1, 2131710135, "ACHMAD SAVERO WINDI PRADANA", 1),
    (2, 2131710132, "AHMAD SHODIKIN", 1),
    (3, 2131710150, "AKBAR RAHMADANI", 1),
    (4, 2131710082, "ARIELIA ZAHWA", 1),
    (5, 2131710093, "ARYA WILDHANI PUTRA", 1),
    (6, 2131710090, "ASHRAF NAWAF", 1),
    (7, 2131710120, "BAGUS NURCAHYO", 1),
    (8, 2131710076, "BAGUS TEJO WALUYO", 1),
    (9, 2131710083, "BENAYA LASKAR FIRDAUS", 1),
    (10, 2131710071, "DIVA GRACIA SALMANTA CANDRA", 1),
    (11, 2131710138, "FARHAN ASYAM ALFITRA", 1),
    (12, 2131710129, "GADHIS PRAMESTYA ARIFIN", 1),
    (13, 2131710136, "GALUR ARASY LUMINTANG", 1),
    (14, 2131710073, "IBNU TSALIS ASSALAM", 1),
    (15, 2131710022, "INDIRA IRAWATI PUTRI", 1),
    (16, 2131710053, "M ARIESTA NAEVA ARYA DHUTA", 1),
    (17, 2131710097, "MOCH AZHARUL BACHTIAR", 1),
    (18, 2131710098, "MUHAMMAD DAFFA FARRELL AUDYVIE", 1),
    (19, 2131710115, "MUHAMMAD FIRDAUS FADLURROCHMAN PUTRA", 1),
    (20, 2131710140, "MUHAMMAD HELMI PERMANA AGUNG", 1),
    (21, 2131710099, "MUHAMMAD RAYHAN GIBRAN", 1),
    (22, 2131710047, "NABILA RASYIDAH", 1),
    (23, 2131710107, "RAMA WIJAYA", 1),
    (24, 2131710142, "SELLY AMELIA PUTRI", 1),
    (25, 2131710038, "YUSUFA HAIDAR", 1),
    (26, 2131710023, "ZHAFIRAH ARINUSI", 1);

INSERT INTO matkul (nama_matkul, id_dosen) VALUES 
    ('Agama',50),
    ('Bahasa Inggris', 32),
    ('Basis Data', 27),
    ('Desain Pemrograman Web', 86),
    ('Kewarganegaraan', 81),
    ('Pengembangan Perangkat Lunak Berbasis Object', 9),
    ('Penulisan Ilmiah', 41),
    ('Praktikum Basis Data', 27),
    ('Praktikum Struktur Data', 40),
    ('Struktur Data', 40);

INSERT INTO nilai VALUES 
    (NULL, '2131710082', 1, 90, 89, 93, 100, 90, 89, 88, 90, 93, NULL),
    (NULL, '2131710071', 1, 90, 85, 93, 97, 90, 100, 89, 90, 93, NULL),
    (NULL, '2131710136', 1, 90, 87, 93, 100, 90, 100, 90, 100, 100, NULL),
    (NULL, '2131710073', 1, 90, 85, 93, 93, 90, 98, 91, 90, 93, NULL),
    (NULL, '2131710022', 1, 90, 87, 93, 93, 90, 89, 92, 90, 93, NULL);

/*GOOD QUESTION :|*/
SELECT mahasiswa.nim AS 'NIM',
    nama_kelas AS 'Kelas', 
    nama AS 'Nama', 
    nama_matkul AS 'Mata Kuliah', 
    total_nilai AS 'Nilai' FROM nilai 
    JOIN matkul ON nilai.id_matkul = matkul.id_matkul 
    JOIN mahasiswa ON nilai.nim = mahasiswa.nim 
    JOIN kelas ON mahasiswa.id_kelas = kelas.id_kelas;