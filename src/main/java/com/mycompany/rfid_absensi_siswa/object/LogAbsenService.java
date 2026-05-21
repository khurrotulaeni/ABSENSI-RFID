package com.mycompany.rfid_absensi_siswa.object;

import absensiRFID.DAO.GenericDAO;
import com.mongodb.client.model.Filters;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.bson.conversions.Bson;

public class LogAbsenService {

    private final GenericDAO<LogAbsen> logRepo;
    private final SiswaService siswaService;

    public LogAbsenService() {
        this.logRepo = new GenericDAO<>("log_absensi", LogAbsen.class);
        this.siswaService = new SiswaService();
    }

    // CREATE - Catat absensi otomatis dari RFID
    public void catatAbsensi(String uidRfid) {

        Siswa siswa = siswaService.cariSiswaByRFID(uidRfid);

        if (siswa == null) {
            System.out.println("Siswa tidak ditemukan. UID RFID tidak terdaftar.");
            return;
        }

        String tanggal = LocalDate.now().toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String waktu = LocalTime.now().format(formatter) + " WIB";

        if (sudahAbsenHariIni(siswa.getIdSiswa(), tanggal)) {
            System.out.println("Siswa sudah melakukan absensi hari ini.");
            return;
        }

        LogAbsen logBaru = new LogAbsen(
                siswa.getIdSiswa(),
                siswa.getNamaLengkap(),
                siswa.getKelasSiswa(),
                tanggal,
                waktu,
                "HADIR",
                uidRfid
        );

        logRepo.save(logBaru);

        System.out.println("Absensi berhasil dicatat untuk: " + siswa.getNamaLengkap());
    }

    // READ - Cek apakah siswa sudah absen hari ini
    public boolean sudahAbsenHariIni(String idSiswa, String tanggal) {
        Bson filter = Filters.and(
                Filters.eq("idSiswa", idSiswa),
                Filters.eq("tanggal", tanggal)
        );

        return logRepo.findOne(filter) != null;
    }

    // READ ALL
    public List<LogAbsen> getAllLog() {
        return logRepo.findAll();
    }

    public void tampilkanSemuaLog() {
        List<LogAbsen> daftarLog = logRepo.findAll();

        System.out.println("===== LOG ABSENSI SISWA =====");
        for (LogAbsen log : daftarLog) {
            System.out.println(log.toString());
        }
    }

    // READ BY ID SISWA
    public void tampilkanLogByIdSiswa(String idSiswa) {
        List<LogAbsen> daftarLog = logRepo.findAll();

        System.out.println("===== LOG ABSENSI ID SISWA: " + idSiswa + " =====");

        for (LogAbsen log : daftarLog) {
            if (log.getIdSiswa().equals(idSiswa)) {
                System.out.println(log.toString());
            }
        }
    }

    // DELETE
    public void hapusLogByIdSiswa(String idSiswa) {
        logRepo.delete("idSiswa", idSiswa);

        System.out.println("Log absensi siswa dengan ID " + idSiswa + " berhasil dihapus.");
    }
}