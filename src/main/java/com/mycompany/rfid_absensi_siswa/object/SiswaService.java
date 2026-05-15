/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

import absensiRFID.DAO.GenericDAO;
import com.mongodb.client.model.Filters;
import java.util.List;
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

    public void tambahSiswa(String uidRfid, String nis, String namaLengkap, String kelas) {
        Siswa siswaBaru = new Siswa(uidRfid, nis, namaLengkap, kelas);
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
    Bson filter = Filters.eq("uid_rfid", uid);
    return siswaRepo.findOne(filter);
}

    // UPDATE
    public void perbaruiKelas(String nis, String kelasBaru) {
        Bson filter = Filters.eq("nis", nis);
        Siswa siswa = siswaRepo.findOne(filter);

        if (siswa != null) {
            siswa.setKelas(kelasBaru);
            siswaRepo.update(filter, siswa);

            System.out.println("Data kelas berhasil diperbarui.");
        }
    }

    // DELETE
    public void hapusSiswa(String nis) {
        Bson filter = Filters.eq("nis", nis);
        siswaRepo.delete(filter);

        System.out.println("Data siswa berhasil dihapus.");
    }
}