
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

/**
 *
 * @author titosukamenabung
 */
public class Siswa_Users {
    private String uidRfid;
    private String nis;
    private String namaLengkap;
    private String kelas;
    
    public Siswa_Users() {
    }

    public Siswa_Users(String uidRfid, String nis, String namaLengkap, String kelas) {
        this.uidRfid = uidRfid;
        this.nis = nis;
        this.namaLengkap = namaLengkap;
        this.kelas = kelas;
    }
    
    @Override
    public String toString() {
        return "Siswa_Users{" + 
                "uidRfid=" + uidRfid + 
                ", nis=" + nis + 
                ", namaLengkap=" + namaLengkap + 
                ", kelas=" + kelas + '}';
    }

    public String getUidRfid() {
        return uidRfid;
    }

    public void setUidRfid(String uidRfid) {
        this.uidRfid = uidRfid;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
        
}
