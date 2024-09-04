package com.example.test;

public class Users {
    private String name;
    private String email;
    private String hobby;

    // Default constructor required for calls to DataSnapshot.getValue(Users.class)
    public Users() {
    }

    public Users(String name, String email, String hobby) {
        this.name = name;
        this.email = email;
        this.hobby = hobby;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
