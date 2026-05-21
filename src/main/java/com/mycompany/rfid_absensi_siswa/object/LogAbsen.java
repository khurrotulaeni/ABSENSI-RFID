package com.mycompany.rfid_absensi_siswa.object;

public class LogAbsen {

    private String idSiswa;
    private String namaLengkap;
    private String kelasSiswa;
    private String tanggal;
    private String waktu;
    private String status;
    private String uidRfid;

    public LogAbsen() {
    }

    public LogAbsen(String idSiswa, String namaLengkap, String kelasSiswa, String tanggal, String waktu, String status, String uidRfid) {
        this.idSiswa = idSiswa;
        this.namaLengkap = namaLengkap;
        this.kelasSiswa = kelasSiswa;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.status = status;
        this.uidRfid = uidRfid;
    }

    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getKelasSiswa() {
        return kelasSiswa;
    }

    public void setKelasSiswa(String kelasSiswa) {
        this.kelasSiswa = kelasSiswa;
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

    @Override
    public String toString() {
        return "LogAbsen{"
                + "idSiswa='" + idSiswa + '\''
                + ", namaLengkap='" + namaLengkap + '\''
                + ", kelasSiswa='" + kelasSiswa + '\''
                + ", tanggal='" + tanggal + '\''
                + ", waktu='" + waktu + '\''
                + ", status='" + status + '\''
                + ", uidRfid='" + uidRfid + '\''
                + '}';
    }
}