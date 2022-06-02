package com.rku_21soeca21002.tutorial11;

public class User {
    private String name;
    private String email;
    private String number;
    private String website;

    public User(String name, String email, String number, String website) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.website = website;
    }

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
