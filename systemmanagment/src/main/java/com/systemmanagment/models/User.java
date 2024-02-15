package com.systemmanagment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;


@Document(collection = "users")
@Entity
public class User {
    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public User(String id, String firstName, String lastName, String email, String password) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.password = password;
    }
}
