/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

import absensiRFID.DAO.GenericDAO;
import com.mongodb.client.model.Filters;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author ADVAN
 */
public class LogAbsenService {

    private final GenericDAO<LogAbsen> logRepo;
    private final SiswaService siswaService;

    public LogAbsenService() {
        this.logRepo = new GenericDAO<>("log_absensi", LogAbsen.class);
        this.siswaService = new SiswaService();
    }

    // CREATE - Catat absensi otomatis dari RFID
    public void catatAbsensi(String uidRfid) {

        // Cari siswa berdasarkan UID RFID
        Siswa siswa = siswaService.cariSiswaByRFID(uidRfid);

        if (siswa == null) {
            System.out.println("Siswa tidak ditemukan. UID RFID tidak terdaftar.");
            return;
        }

        // Format tanggal & waktu
        String tanggal = LocalDate.now().toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String waktu = LocalTime.now().format(formatter) + " WIB";

        // Cek apakah siswa sudah absen hari ini
        if (sudahAbsenHariIni(siswa.getNis(), tanggal)) {
            System.out.println("Siswa sudah melakukan absensi hari ini.");
            return;
        }

        // Simpan log absensi baru
        LogAbsen logBaru = new LogAbsen(
                siswa.getNis(),
                siswa.getNamaLengkap(),
                siswa.getKelas(),
                tanggal,
                waktu,
                "HADIR",
                uidRfid
        );

        logRepo.save(logBaru);

        System.out.println("Absensi berhasil dicatat untuk: " + siswa.getNamaLengkap());
    }

    // READ - Cek apakah siswa sudah absen hari ini
    public boolean sudahAbsenHariIni(String nis, String tanggal) {
        Bson filter = Filters.and(
                Filters.eq("nis", nis),
                Filters.eq("tanggal", tanggal)
        );

        return logRepo.findOne(filter) != null;
    }

    // READ ALL - Tampilkan semua log absensi
    public void tampilkanSemuaLog() {
        List<LogAbsen> daftarLog = logRepo.findAll();

        System.out.println("===== LOG ABSENSI SISWA =====");
        for (LogAbsen log : daftarLog) {
            System.out.println(log.toString());
        }
    }

    // READ BY NIS
    public void tampilkanLogByNIS(String nis) {
        List<LogAbsen> daftarLog = logRepo.findAll();

        System.out.println("===== LOG ABSENSI NIS: " + nis + " =====");

        for (LogAbsen log : daftarLog) {
            if (log.getNis().equals(nis)) {
                System.out.println(log.toString());
            }
        }
    }

    // DELETE
    public void hapusLogByNIS(String idSiswa) {
        logRepo.delete("idSiswa", idSiswa);

        System.out.println("Log absensi siswa dengan NIS " + idSiswa + " berhasil dihapus.");
    }
}
