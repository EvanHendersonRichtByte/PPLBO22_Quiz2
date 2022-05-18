import java.util.Scanner;

public class Mainnn {
    public static void menu() {
        System.out.println("--------------------");
        System.out.println("|1. Input Data     |");
        System.out.println("|2. Tampilkan Data |");
        System.out.println("|3. Ubah Data      |");
        System.out.println("|4. Hapus Data     |");
        System.out.println("--------------------");
        System.out.print("Pilihan : ");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int pil1, pil2;

        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Mata Kuliah");
            System.out.println("3. Kelas");
            System.out.println("4. Nilai");
            System.out.println("5. Keluar");
            System.out.print("Pilihan menu : ");
            pil1 = s.nextInt();
            if (pil1 == 1) {
                Mahasiswa mhs = new Mahasiswa();
                menu();
                pil2 = s.nextInt();
                switch (pil2) {
                    case 1:
                        mhs.create();
                        break;
                    case 2:
                        mhs.read();
                        break;
                    case 3:
                        mhs.update();
                        break;
                    case 4:
                        mhs.delete();
                        break;
                }
            } else if (pil1 == 2) {
                Matkul mk = new Matkul();
                menu();
                pil2 = s.nextInt();
                switch (pil2) {
                    case 1:
                        mk.create();
                        break;
                    case 2:
                        mk.read();
                        break;
                    case 3:
                        mk.update();
                        break;
                    case 4:
                        mk.delete();
                        break;
                }
            } else if (pil1 == 3) {
                Kelas kls = new Kelas();
                menu();
                pil2 = s.nextInt();
                switch (pil2) {
                    case 1:
                        kls.create();
                        break;
                    case 2:
                        kls.read();
                        break;
                    case 3:
                        kls.update();
                        break;
                    case 4:
                        kls.delete();
                        break;
                }
            } else if (pil1 == 4) {
                Nilai n = new Nilai();
                menu();
                pil2 = s.nextInt();
                switch (pil2) {
                    case 1:
                        n.create();
                        break;
                    case 2:
                        n.read();
                        break;
                    case 3:
                        n.update();
                        break;
                    case 4:
                        n.delete();
                        break;
                }
            } else if (pil1 == 5) {
                break;
            }
        }
    }
}
