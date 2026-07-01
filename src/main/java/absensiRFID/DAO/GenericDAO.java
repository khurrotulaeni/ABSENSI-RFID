/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package absensiRFID.DAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import absensiRFID.util.MongoManager;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T> implements BaseDAO<T> {
    private final MongoCollection<T> collection;
    private final Class<T> clazz;

    public GenericDAO(String collectionName, Class<T> clazz) {
        this.clazz = clazz;
        this.collection = MongoManager.getDatabase().getCollection(collectionName, clazz);
    }

    @Override
    public void save(T entity) {
        // Mengubah objek Java (Entity) menjadi Document MongoDB
        collection.insertOne(entity);
    }

    @Override
    public void update(String idField, String idValue, T entity) {
        Bson filter = Filters.eq(idField, idValue);
        collection.replaceOne(filter, entity);
    }
    
    @Override
    public void delete(String idField, String idValue) {
        Bson filter = Filters.eq(idField, idValue);
        collection.deleteOne(filter);
    }
    
    @Override
    public List<T> getAll() {
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public List<T> findAll(){
        return collection.find().into(new ArrayList<>());
    }
    
     @Override
     public T findOne (Bson filter) {
         return collection.find(filter).first();
     }
     
    @Override
    public List<T> findMany(Bson filter) {
        return collection.find(filter).into(new ArrayList<>());
    }
}
