package perpustakaan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TampilkanBuku {
    public static void tampilkanSemuaBuku() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM buku";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("=== Daftar Buku ===");
            while (rs.next()) {
                int id = rs.getInt("id_buku");
                String judul = rs.getString("judul");
                String pengarang = rs.getString("pengarang");
                int tahun = rs.getInt("tahun_terbit");

                System.out.println(id + " | " + judul + " | " + pengarang + " | " + tahun);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Gagal menampilkan data: " + e.getMessage());
        }
    }
}
