/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

import absensiRFID.DAO.GenericDAO;
import com.mongodb.client.model.Filters;
import java.util.List;
import javax.swing.JTable;
import org.bson.conversions.Bson;

/**
 *
 * @author titosukamenabung
 */
public class SiswaService {

    private final GenericDAO<Siswa> siswaRepo;

    public SiswaService() {
        this.siswaRepo = new GenericDAO<>("siswa", Siswa.class);
    }

    // CREATE
    public void tambahSiswa(Siswa siswaBaru) {
        siswaRepo.save(siswaBaru);
    }

    public void tambahSiswa(String uidRfid, String idSiswa, String namaLengkap, String kelas) {
        Siswa siswaBaru = new Siswa(uidRfid, idSiswa, namaLengkap, kelas);
        siswaRepo.save(siswaBaru);
    }

    // READ ALL
    public void tampilkanDaftarSiswa() {
        List<Siswa> daftar = siswaRepo.findAll();

        System.out.println("--- Daftar Siswa SMA ---");
        for (Siswa s : daftar) {
            System.out.println(s.toString());
        }
    }

    // READ ONE
    public Siswa cariSiswaByRFID(String uid) {
    Bson filter = Filters.eq("uidRfid", uid);
    return siswaRepo.findOne(filter);
}

    // UPDATE
    public void perbaruiKelas(String idSiswa, String kelasBaru) {
        Bson filter = Filters.eq("idSiswa", idSiswa);
        // Cari data siswa 
        Siswa siswa = siswaRepo.findOne(filter);

        if (siswa != null) {
            // set kelas baru ke objek siswa 
            siswa.setKelas(kelasBaru);
            siswaRepo.update("idSiswa", idSiswa, siswa);

            System.out.println("Data kelas berhasil diperbarui.");
        }
    }

    // DELETE
    public void hapusSiswa(String idSiswa) {
        
        siswaRepo.delete("idSiswa", idSiswa);

        System.out.println("Data siswa berhasil dihapus.");
    }

    public void tampilanSiswa(javax.swing.JTable jTable1, String key) {
        // 1. Panggil findAll() sesuai yang ada di GenericDAO kamu
        List<Siswa> daftarSiswa = siswaRepo.findAll();
        
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] {"USERS ID", "UID RFID", "NAMA", "JURUSAN", "KELAS"}
        );
        
        for (Siswa s : daftarSiswa) {
            // Jika ada kata kunci pencarian, kita cari kecocokan secara umum saja
            if (key != null && !key.isEmpty()) {
                // Trik aman: Ubah seluruh objek siswa jadi teks, lalu cek apakah mengandung keyword
                if (!s.toString().toLowerCase().contains(key.toLowerCase())) {
                    continue; // Lewati jika tidak cocok
                }
            }
            
            // 2. MASUKKAN DATA KE BARIS TABEL
            // JIKA ADA YANG GARIS MERAH, IKUTI TRIK DI BAWAH KODE INI!
            model.addRow(new Object[] {
                s.getidSiswa(),       // Kolom USERS ID
                s.getUidRfid(),       // Kolom UID RFID
                s.getNamaLengkap(),   // Kolom NAMA
                s.getJurusan(),       // Kolom JURUSAN
                s.getKelas()          // Kolom KELAS
            });
        }
        
        jTable1.setModel(model);
    }
}