package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.time.LocalDate;
import java.util.List;

//@Entity
public class Person extends PanacheEntity {
    public String name;
    public LocalDate dateOfBirth;
    public Status status;

    public static Person findByName(String name){
        return find("name", name).firstResult();
    }

    public static List<Person> findAlive(){
        return list("status", Status.Alive);
    }

    public static void deleteStefs(){
        delete("name", "Stef");
    }
}
