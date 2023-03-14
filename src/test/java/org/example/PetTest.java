package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.ebean.DB;
import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import org.example.model.Pet;
import org.junit.jupiter.api.Test;

public class PetTest {

    @Test
    void testSingle() {
        // simulate using a custom object mapper
        ObjectMapper mapper = new ObjectMapper();

        // simulate creating a database configuration for the first time
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.loadFromProperties();
        dbConfig.setObjectMapper(mapper);
        Database db = DatabaseFactory.create(dbConfig);

        db.save(new Pet());
    }

    @Test
    void testDouble() {
        // simulate using a custom object mapper
        ObjectMapper mapper = new ObjectMapper();

        // simulate creating a database configuration twice
        // this often happens when using spring tests where several
        // contexts can be created and destroyed - causing multiple
        // calls to create the database configuration from properties
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.loadFromProperties();
        dbConfig.setObjectMapper(mapper);
        Database db = DatabaseFactory.create(dbConfig);

        dbConfig = new DatabaseConfig();
        dbConfig.loadFromProperties();
        dbConfig.setObjectMapper(mapper);
        db = DatabaseFactory.create(dbConfig);
        db.save(new Pet());
    }

}
