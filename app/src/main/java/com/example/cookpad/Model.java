package com.example.cookpad;

import android.media.Image;

public class Model {
    private String nume;
    private String ingrediente;
    private String reteta;

    public Model(String nume, String ingrediente, String reteta) {
        this.nume = nume;
        this.ingrediente=ingrediente;
        this.reteta=reteta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }


    public String getReteta() {
        return reteta;
    }

    public void setReteta(String reteta) {
        this.reteta = reteta;
    }


    @Override
    public String toString() {
        return "Model{" +
                ",nume='" + nume + '\'' +
                "ingrediente=" + ingrediente+'\'' +
                "reteta=" + reteta+'\'' +
                '}';
    }
}
