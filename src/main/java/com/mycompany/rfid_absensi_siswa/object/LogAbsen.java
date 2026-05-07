/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

import java.time.LocalDateTime;

/**
 *
 * @author titosukamenabung
 */
public class LogAbsen {

    private String nis;
    private String namaLengkap;
    private String kelas;
    private String tanggal;
    private String waktu;
    private String status;
    private String uidRfid;

    public LogAbsen(String nis, String namaLengkap, String kelas, String tanggal, String waktu, String status, String uidRfid) {
        this.nis = nis;
        this.namaLengkap = namaLengkap;
        this.kelas = kelas;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.status = status;
        this.uidRfid = uidRfid;
    }

    public LogAbsen() {
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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUidRfid() {
        return uidRfid;
    }

    public void setUidRfid(String uidRfid) {
        this.uidRfid = uidRfid;
    }

}