package com.example.sem4;

public class Mancare {
    public String Denumire;
    public int calorii;
    public boolean vegetarian;
    public String tip;
    public Boolean picant;

    public float rating;

    public Mancare(String denumire, int calorii, boolean vegetarian, String tip, Boolean picant, float rating) {
        Denumire = denumire;
        this.calorii = calorii;
        this.vegetarian = vegetarian;
        this.tip = tip;
        this.picant = picant;
        this.rating = rating;
    }

    public String bucatarie;

    public Mancare(String denumire, int calorii, boolean vegetarian, String tip, Boolean picant, float rating, String bucatarie) {
        this(denumire, calorii, vegetarian, tip, picant, rating);
        this.bucatarie = bucatarie;
    }

    @Override
    public String toString() {
        return "Mancare: " + Denumire +
                "\nCalorii: " + calorii +
                "\nVegetarian: " + (vegetarian ? "da" : "nu") +
                "\nTip: " + tip +
                "\nBucatarie: " + bucatarie +
                "\nRating: " + rating +
                "\nPicant: " + (picant ? "da" : "nu");
    }
}
