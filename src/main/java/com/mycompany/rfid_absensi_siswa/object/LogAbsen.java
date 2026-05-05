/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfid_absensi_siswa.object;

import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class LogAbsen {
    private String idLog;
    private String sidRfid;
    private LocalDateTime waktuTap;
    private String Status;

    public String getIdLog() {
        return idLog;
    }

    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }

    public String getSidRfid() {
        return sidRfid;
    }

    public void setSidRfid(String sidRfid) {
        this.sidRfid = sidRfid;
    }

    public LocalDateTime getWaktuTap() {
        return waktuTap;
    }

    public void setWaktuTap(LocalDateTime waktuTap) {
        this.waktuTap = waktuTap;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
