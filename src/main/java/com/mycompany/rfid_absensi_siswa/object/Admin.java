package com.mycompany.rfid_absensi_siswa.object;

import org.bson.types.ObjectId;

public class Admin {

    private String email;
    private String password;
    private String namaLengkap;
    private String role;
    private ObjectId id;

    public Admin() {

    }

    public Admin(String email, String password, String namaLengkap, String role) {
        this.email = email;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{"
                + "email='" + email + '\''
                + ", namaLengkap='" + namaLengkap + '\''
                + ", role='" + role + '\''
                + '}';
    }
}
