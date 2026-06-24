/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

/**
 *
 * @author organizer
 */
public class Pegawai {

    private String idPegawai;
    private String namaPegawai;
    private String jabatan;
    private String noHp;

    public Pegawai() {
    }

    public Pegawai(
            String idPegawai,
            String namaPegawai,
            String jabatan,
            String noHp
    ) {

        this.idPegawai = idPegawai;
        this.namaPegawai = namaPegawai;
        this.jabatan = jabatan;
        this.noHp = noHp;

    }

    @Override
    public String toString() {

        return "Pegawai{" +
                "idPegawai=" + idPegawai +
                ", namaPegawai=" + namaPegawai +
                ", jabatan=" + jabatan +
                ", noHp=" + noHp + '}';

    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(
            String idPegawai
    ) {
        this.idPegawai = idPegawai;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(
            String namaPegawai
    ) {
        this.namaPegawai = namaPegawai;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(
            String jabatan
    ) {
        this.jabatan = jabatan;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(
            String noHp
    ) {

        this.noHp = noHp;
    }
}
