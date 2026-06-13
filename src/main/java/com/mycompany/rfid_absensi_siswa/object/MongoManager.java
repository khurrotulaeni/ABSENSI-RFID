package com.mycompany.rfid_absensi_siswa.object;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoManager {

    private static MongoClient mongoClient;
    private static final String DATABASE_NAME = "Absensi";

    // GLOBAL POJO REGISTRY
    private static final CodecRegistry pojoCodecRegistry =
            CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(
                            PojoCodecProvider.builder()
                                    .automatic(true)
                                    .build()
                            )
            );

    public static MongoDatabase getDatabase() {

        if (mongoClient == null) {

            mongoClient = MongoClients.create(
                    "mongodb://localhost:27017"
            );
        }
        // SELALU return dengan codec registry
        return mongoClient
                .getDatabase(DATABASE_NAME)
                .withCodecRegistry(pojoCodecRegistry);
    }
}