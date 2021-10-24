package com.example.cookpad;

import java.io.Serializable;

public class Cont implements Serializable{

    private String nume;
    private String email;
    private String parola;

    public Cont() {
    }

    public Cont(String nume, String email, String parola) {
        this.nume = nume;
        this.email = email;
        this.parola = parola;

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'';
    }

}
