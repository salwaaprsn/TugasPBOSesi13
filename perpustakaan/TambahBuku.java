package perpustakaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TambahBuku {
    public static void tambahBukuBaru() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Judul: ");
        String judul = scanner.nextLine();

        System.out.print("Pengarang: ");
        String pengarang = scanner.nextLine();

        System.out.print("Tahun Terbit: ");
        int tahun = scanner.nextInt();

        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO buku (judul, pengarang, tahun_terbit) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, judul);
            pstmt.setString(2, pengarang);
            pstmt.setInt(3, tahun);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data buku berhasil ditambahkan.");
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Gagal menambahkan data: " + e.getMessage());
        }
    }
}