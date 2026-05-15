/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package absensiRFID.DAO;

import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author titosukamenabung
 */
public interface BaseDAO<T> {
    void save(T entity);
    void update(String idField, String idValue, T entity);
    void delete(String idField, String idValue);
    java.util.List<T> getAll();
    
     // Operasi Searching/Reading
    List<T> findAll();
    T findOne(Bson filter); // Mencari satu data spesifik
    List<T> findMany(Bson filter); // Mencari banyak data berdasarkan kriteria
}
    

