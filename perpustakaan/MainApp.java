package perpustakaan;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Aplikasi Perpustakaan ===");
            System.out.println("1. Tampilkan Data Buku");
            System.out.println("2. Tambah Data Buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    TampilkanBuku.tampilkanSemuaBuku();
                    break;
                case 2:
                    TambahBuku.tambahBukuBaru();
                    break;
                case 3:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);
    }
}
