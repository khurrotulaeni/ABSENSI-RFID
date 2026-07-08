/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package absensiRFID.services;

import com.mycompany.rfid_absensi_siswa.object.Admin;
import absensiRFID.DAO.GenericDAO;
import absensiRFID.GUI.AdminPage; // Halaman tujuan
import absensiRFID.GUI.LoginPage;
import absensiRFID.util.EncryptionUtils; // Menggunakan EncryptionUtils AES milikmu
import com.mongodb.client.model.Filters;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author mnish
 */
public class AuthService {

    // Inisialisasi DAO untuk koleksi "siswa"
    private final GenericDAO<Admin> adminDAO = new GenericDAO<>("siswa", Admin.class);

    /**
     * Melakukan proses login dengan memvalidasi kredensial (AES Encryption).
     *
     * @param username
     * @param plainPassword
     * @param loginPage
     */
    public void login(String username, String plainPassword, LoginPage loginPage) {
        // 1. Mengubah password input menjadi format AES sesuai EncryptionUtils
        String hashedInput = EncryptionUtils.encrypt(plainPassword);

        // Tambahan Debug: Melihat hasil string enkripsi di tab Output NetBeans saat tombol diklik
        System.out.println("DEBUG LOGIN -> Username dicari: " + username);
        System.out.println("DEBUG LOGIN -> Hasil Enkripsi Password: " + hashedInput);

        // 2. Mencari user di database berdasarkan username DAN password terenkripsi
        Admin admin = adminDAO.findOne(Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", hashedInput)
        ));

        // 3. Validasi hasil pencarian
        if (admin != null) {
            // Berhasil: Masuk ke Halaman Admin
            AdminPage admPage = new AdminPage();
            admPage.setLocationRelativeTo(null);
            admPage.setVisible(true);
            admPage.setExtendedState(Frame.MAXIMIZED_BOTH);
            loginPage.setVisible(false);
        } else {
            // Gagal: Notifikasi Error
            JOptionPane.showMessageDialog(null,
                    "Username atau Password Salah!",
                    "Login Gagal",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metode untuk menambahkan user/admin baru ke database. Implementasi sesuai
     * target SPRINT 3 untuk pengamanan kredensial [2].
     *
     * @param fullname Nama lengkap siswa
     * @param username Username untuk login
     * @param plainPassword Password mentah (akan di-hash otomatis)
     */
    public void registerAdmin(String fullname, String username, String plainPassword) {
        // 1. Proses Hashing: Mengamankan password mentah menggunakan SHA-256 [1]
        String hashedPassword = EncryptionUtils.encrypt(plainPassword);

        // 2. Instansiasi Objek: Membuat objek User baru dengan password yang sudah di-hash
        // lastLogin disetel null karena user baru belum pernah masuk sistem
        Admin newAdmin = new Admin(fullname, username, hashedPassword, null);

        // 3. Operasi Create: Menyimpan dokumen user ke koleksi MongoDB melalui GenericDAO [3], [4]
        try {
            adminDAO.save(newAdmin);
            JOptionPane.showMessageDialog(null, "Admin Berhasil Didaftarkan!");
        } catch (Exception e) {
            System.err.println("Gagal mendaftarkan user: " + e.getMessage());
        }
    }
}
