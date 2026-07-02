package absensiRFID.services;

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
import com.mycompany.rfid_absensi_siswa.object.Admin;
import org.bson.conversions.Bson;

public class AdminService {

    private final GenericDAO<Admin> adminRepo;

    public AdminService() {
        this.adminRepo = new GenericDAO<>("admin", Admin.class);
    }

    // REGISTER ADMIN
    public void tambahAdmin(Admin adminBaru) {
        adminRepo.save(adminBaru);
    }

    // LOGIN
    public Admin login(String username, String password) {

        Bson filter = Filters.and(
                Filters.eq("email", username),
                Filters.eq("password", password)
        );

        return adminRepo.findOne(filter);
    }

    // CEK USERNAME
    public boolean usernameSudahAda(String username) {

        Bson filter = Filters.eq("username", username);

        return adminRepo.findOne(filter) != null;
    }
}

