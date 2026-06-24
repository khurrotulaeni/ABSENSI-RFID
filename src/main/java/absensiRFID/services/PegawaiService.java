/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package absensiRFID.services;

import absensiRFID.DAO.GenericDAO;
import com.mongodb.client.model.Filters;
import java.util.List;
import javax.swing.JTable;
import org.bson.conversions.Bson;

import com.mycompany.rfid_absensi_siswa.object.Pegawai;
/**
 *
 * @author organizer
 */
public class PegawaiService {
    private final GenericDAO<Pegawai> pegawaiRepo;

    public PegawaiService() {
        this.pegawaiRepo =
        new GenericDAO<>(
            "Pegawai",
            Pegawai.class
        );
}
    // CREATE
    public void tambahPegawai(
        Pegawai pegawaiBaru
    ) {
        pegawaiRepo.save(
            pegawaiBaru
        );

    }

    // READ
    public List<Pegawai> tampilSemua() {
        return pegawaiRepo.findAll();
    }

    // READ ONE
    public Pegawai cariPegawai(String id) 
    {
        Bson filter =
        Filters.eq(
            "idPegawai",
            id
        );

        return pegawaiRepo
        .findOne(
            filter
        );
    }

    // UPDATE
    public void updatePegawai(
        Pegawai pegawai
    ) {

        pegawaiRepo.update(
            "idPegawai",
            pegawai.getIdPegawai(),
            pegawai
        );

    }

    // DELETE
    public void hapusPegawai( String id) {
        pegawaiRepo.delete("idPegawai",id);

    }

    public void tampilPegawai( JTable table, String key) {

        List<Pegawai> data =
        pegawaiRepo.findAll();

        javax.swing.table
        .DefaultTableModel model =
        new javax.swing.table
        .DefaultTableModel(

        new Object[][]{},

        new String[]{
            "ID",
            "NAMA",
            "JABATAN",
            "NO HP"
        }

        );

        for (Pegawai p: data) 
        {
            if (key != null&&!key.isEmpty()) 
           {
            if (!p.toString()
                .toLowerCase()
                .contains(
                        key
                        .toLowerCase()
                    )
                ) {
                    continue;
                }
            }

            model.addRow(
                new Object[]{
                    p.getIdPegawai(),
                    p.getNamaPegawai(),
                    p.getJabatan(),
                    p.getNoHp()
                }
            );
        }
        
        table.setModel(
            model
        );
    }
}
