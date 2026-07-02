/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package absensiRFID.services;

import absensiRFID.DAO.GenericDAO;
import com.mycompany.rfid_absensi_siswa.object.Siswa;

/**
 *
 * @author ADVAN
 */
public class attendanceService {

    private final GenericDAO<Siswa> siswaRepo;
    private final GenericDAO<Attendance> attendanceRepo;

    public attendanceService() {
        siswaRepo = new GenericDAO<>("siswa", Siswa.class);
        attendanceRepo = new GenericDAO<>("attendance", Attendance.class);
    }

}
