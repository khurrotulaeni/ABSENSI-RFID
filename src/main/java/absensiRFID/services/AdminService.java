package absensiRFID.services;

import absensiRFID.DAO.GenericDAO;
import com.mongodb.client.model.Filters;
import com.mycompany.rfid_absensi_siswa.object.Admin;
import org.bson.conversions.Bson;

// IMPORT UTILS ENKRIPSI ANDA
import absensiRFID.util.EncryptionUtils;

public class AdminService {

    private final GenericDAO<Admin> adminRepo;

    public AdminService() {
        this.adminRepo = new GenericDAO<>("admin", Admin.class);
    }

    // REGISTER ADMIN
    public void tambahAdmin(Admin adminBaru) {
        // Enkripsi dulu sebelum disimpan ke database saat registrasi
        String passwordAsli = adminBaru.getPassword();
        String passwordEnkripsi = EncryptionUtils.encrypt(passwordAsli);
        adminBaru.setPassword(passwordEnkripsi);
        
        adminRepo.save(adminBaru);
    }

    // LOGIN
    public Admin login(String username, String password) {
        // KUNCI UTAMA: Ubah password inputan GUI ('admin123') menjadi string AES acak
        String passwordEnkripsi = EncryptionUtils.encrypt(password);

        Bson filter = Filters.and(
                Filters.eq("email", username),
                Filters.eq("password", passwordEnkripsi) // Mencocokkan AES vs AES
        );

        return adminRepo.findOne(filter);
    }

    // CEK USERNAME
    public boolean usernameSudahAda(String username) {
        Bson filter = Filters.eq("username", username);
        return adminRepo.findOne(filter) != null;
    }
}