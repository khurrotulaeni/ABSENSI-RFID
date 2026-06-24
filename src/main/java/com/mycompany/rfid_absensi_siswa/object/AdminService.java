package com.mycompany.rfid_absensi_siswa.object;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import absensiRFID.DAO.GenericDAO;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import absensiRFID.util.EncryptionUtils;

public class AdminService {

    private final GenericDAO<Admin> adminRepo;

    public AdminService() {
        this.adminRepo = new GenericDAO<>("admin", Admin.class);
    }

    // REGISTER ADMIN
    public void tambahAdmin(Admin adminBaru) {
        
        adminBaru.setPassword(
            EncryptionUtils.encrypt(adminBaru.getPassword())
        );
        adminRepo.save(adminBaru);
    }

    // LOGIN
    public Admin login(String username, String password) {
        
        String encryptedPassword =
            EncryptionUtils.encrypt(password);
        
        Bson filter = Filters.and(
                Filters.eq("email", username),
                Filters.eq("password", encryptedPassword)
        );

        return adminRepo.findOne(filter);
    }

    // CEK USERNAME
    public boolean usernameSudahAda(String username) {

        Bson filter = Filters.eq("username", username);

        return adminRepo.findOne(filter) != null;
    }
}

