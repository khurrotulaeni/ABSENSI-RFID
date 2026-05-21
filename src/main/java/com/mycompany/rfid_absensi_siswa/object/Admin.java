package com.mycompany.rfid_absensi_siswa.object;

public class Admin {

     private String email;
    private String password;
    private String namaLengkap;
    private String role;

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