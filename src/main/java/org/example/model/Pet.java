package org.example.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pet {

    @Id
    private UUID id;

}
