/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

/**
 *
 * @author titosukamenabung
 */
public class PengajuanIzin {

    private String nis;
    private String namaLengkap;
    private String kelas;
    private String tanggal;
    private String keterangan;
    private String statusPengajuan;

    public PengajuanIzin() {
    }  

    public PengajuanIzin(String nis, String namaLengkap, String kelas, String tanggal, String keterangan, String statusPengajuan) {
        this.nis = nis;
        this.namaLengkap = namaLengkap;
        this.kelas = kelas;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.statusPengajuan = statusPengajuan;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatusPengajuan() {
        return statusPengajuan;
    }

    public void setStatusPengajuan(String statusPengajuan) {
        this.statusPengajuan = statusPengajuan;
    }
}
