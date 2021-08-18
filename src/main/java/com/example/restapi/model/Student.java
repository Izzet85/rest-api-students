package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Student {
    private final UUID id;
    private String name;
    private int age;
    private String email;


    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name,
                   @JsonProperty("age") int age,
                   @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.age= age;
        this.email= email;

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
