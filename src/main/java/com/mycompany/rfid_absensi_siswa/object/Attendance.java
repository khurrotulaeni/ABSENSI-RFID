/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

/**
 *
 * @author ADVAN
 */


import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {

    private String idAttendance;
    private String idSiswa;
    private String uidRfid;
    private String namaLengkap;
    private String jurusanSiswa;
    private String kelasSiswa;
    private LocalDate tanggal;
    private LocalTime jamMasuk;
    private String status;

    public Attendance() {
    }

    public Attendance(String idAttendance, String idSiswa, String uidRfid,
            String namaLengkap, String jurusanSiswa, String kelasSiswa,
            LocalDate tanggal, LocalTime jamMasuk, String status) {

        this.idAttendance = idAttendance;
        this.idSiswa = idSiswa;
        this.uidRfid = uidRfid;
        this.namaLengkap = namaLengkap;
        this.jurusanSiswa = jurusanSiswa;
        this.kelasSiswa = kelasSiswa;
        this.tanggal = tanggal;
        this.jamMasuk = jamMasuk;
        this.status = status;
    }

    public String getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(String idAttendance) {
        this.idAttendance = idAttendance;
    }

    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getUidRfid() {
        return uidRfid;
    }

    public void setUidRfid(String uidRfid) {
        this.uidRfid = uidRfid;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJurusanSiswa() {
        return jurusanSiswa;
    }

    public void setJurusanSiswa(String jurusanSiswa) {
        this.jurusanSiswa = jurusanSiswa;
    }

    public String getKelasSiswa() {
        return kelasSiswa;
    }

    public void setKelasSiswa(String kelasSiswa) {
        this.kelasSiswa = kelasSiswa;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public LocalTime getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(LocalTime jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Attendance{"
                + "idAttendance='" + idAttendance + '\''
                + ", idSiswa='" + idSiswa + '\''
                + ", uidRfid='" + uidRfid + '\''
                + ", namaLengkap='" + namaLengkap + '\''
                + ", jurusanSiswa='" + jurusanSiswa + '\''
                + ", kelasSiswa='" + kelasSiswa + '\''
                + ", tanggal=" + tanggal
                + ", jamMasuk=" + jamMasuk
                + ", status='" + status + '\''
                + '}';
    }
}
