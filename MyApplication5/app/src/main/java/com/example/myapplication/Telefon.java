package com.example.myapplication;

public class Telefon {
    private String marca;
    private String model;
    private double pret;
    private int an;

    public Telefon(String marca, String model, double pret, int an) {
        this.marca = marca;
        this.model = model;
        this.pret = pret;
        this.an = an;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    @Override
    public String toString() {
        return "Telefon{" +
                "marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", pret=" + pret +
                ", an=" + an +
                '}';
    }
}
