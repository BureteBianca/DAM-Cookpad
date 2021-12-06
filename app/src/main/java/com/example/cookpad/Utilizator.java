package com.example.cookpad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "utilizator")
public class Utilizator {
    @PrimaryKey (autoGenerate = true)
    private int idUtilizator;
    @ColumnInfo (name = "nume_utilizator")
    private String numeUtilizator;
    @ColumnInfo (name = "varsta")
    private int varsta;
    @ColumnInfo (name = "mancare")
    private String mancare;
    @ColumnInfo (name = "ingrediente")
    private String ingrediente;
    @ColumnInfo (name = "reteta")
    private String reteta;

    public Utilizator(String numeUtilizator, int varsta, String mancare, String ingrediente, String reteta) {
        this.numeUtilizator= numeUtilizator;
        this.varsta = varsta;
        this.mancare = mancare;
        this.ingrediente = ingrediente;
        this.reteta = reteta;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getMancare() {
        return mancare;
    }

    public void setMancare(String mancare) {
        this.mancare = mancare;
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
        return "Utilizator{" +
                "idUtilizator=" + idUtilizator +
                ", numeUtilizator='" + numeUtilizator + '\'' +
                ", varsta=" + varsta +
                ", mancare=" + mancare +
                ", ingrediente=" + ingrediente +
                ", reteta=" + reteta +
                '}';
    }
}
