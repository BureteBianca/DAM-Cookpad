package com.example.cookpad;

import android.media.Image;

public class Model {
    private String nume;


    public Model(String nume) {
        this.nume = nume;

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Model{" +
                ",nume='" + nume + '\'' +
                '}';
    }
}
