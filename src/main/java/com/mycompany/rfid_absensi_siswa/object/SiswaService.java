/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

import absensiRFID.DAO.GenericDAO;
import com.mongodb.client.model.Filters;
import java.util.List;
import org.bson.conversions.Bson;

public class SiswaService {

    private final GenericDAO<Siswa> siswaRepo;

    public SiswaService() {
        this.siswaRepo = new GenericDAO<>("Siswa", Siswa.class);
    }

    // CREATE
    public void tambahSiswa(Siswa siswaBaru) {
        siswaRepo.save(siswaBaru);
    }

    public void tambahSiswa(String idSiswa, String uidRfid, String namaLengkap, String jurusanSiswa, String kelasSiswa) {
        Siswa siswaBaru = new Siswa(idSiswa, uidRfid, namaLengkap, jurusanSiswa, kelasSiswa);
        siswaRepo.save(siswaBaru);
    }

    // READ ALL
    public List<Siswa> getAllSiswa() {
        return siswaRepo.findAll();
    }

    public void tampilkanDaftarSiswa() {
        List<Siswa> daftar = siswaRepo.findAll();

        System.out.println("--- Daftar Siswa ---");
        for (Siswa s : daftar) {
            System.out.println(s.toString());
        }
    }

    // READ ONE BY RFID
    public Siswa cariSiswaByRFID(String uidRfid) {
        Bson filter = Filters.eq("uidRfid", uidRfid);
        return siswaRepo.findOne(filter);
    }

    // READ ONE BY ID
    public Siswa cariSiswaById(String idSiswa) {
        Bson filter = Filters.eq("idSiswa", idSiswa);
        return siswaRepo.findOne(filter);
    }

    // UPDATE
    public void updateSiswa(String idLama, Siswa siswaBaru) {
        siswaRepo.update("idSiswa", idLama, siswaBaru);
    }

    public void updateSiswa(String idLama, String idSiswa, String uidRfid, String namaLengkap, String jurusanSiswa, String kelasSiswa) {
        Siswa siswaBaru = new Siswa(idSiswa, uidRfid, namaLengkap, jurusanSiswa, kelasSiswa);
        siswaRepo.update("idSiswa", idLama, siswaBaru);
    }

    // DELETE
    public void hapusSiswa(String idSiswa) {
        siswaRepo.delete("idSiswa", idSiswa);
    }

    // VALIDASI DUPLIKASI
    public boolean cekIdSiswaAda(String idSiswa) {
        return cariSiswaById(idSiswa) != null;
    }

    public boolean cekRfidAda(String uidRfid) {
        return cariSiswaByRFID(uidRfid) != null;
    }
}
