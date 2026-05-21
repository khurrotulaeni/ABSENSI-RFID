
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

/**
 *
 * @author titosukamenabung
 */
public class Siswa {

    private String idSiswa;
    private String uidRfid;
    private String namaLengkap;
    private String jurusanSiswa;
    private String kelasSiswa;

    public Siswa() {
    }

    public Siswa(String idSiswa, String uidRfid, String namaLengkap, String jurusanSiswa, String kelasSiswa) {
        this.idSiswa = idSiswa;
        this.uidRfid = uidRfid;
        this.namaLengkap = namaLengkap;
        this.jurusanSiswa = jurusanSiswa;
        this.kelasSiswa = kelasSiswa;
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

    @Override
    public String toString() {
        return "Siswa{"
                + "idSiswa='" + idSiswa + '\''
                + ", uidRfid='" + uidRfid + '\''
                + ", namaLengkap='" + namaLengkap + '\''
                + ", jurusanSiswa='" + jurusanSiswa + '\''
                + ", kelasSiswa='" + kelasSiswa + '\''
                + '}';
    }
}
