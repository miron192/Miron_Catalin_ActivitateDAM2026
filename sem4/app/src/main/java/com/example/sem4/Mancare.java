package com.example.sem4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Mancare implements Serializable, Parcelable {
    public String Denumire;
    public int calorii;
    public boolean vegetarian;
    public String tip;
    public Boolean picant;

    public float rating;

    public String getDenumire() {
        return Denumire;
    }

    public int getCalorii() {
        return calorii;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public String getTip() {
        return tip;
    }

    public Boolean getPicant() {
        return picant;
    }

    public float getRating() {
        return rating;
    }

    public String getBucatarie() {
        return bucatarie;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public void setCalorii(int calorii) {
        this.calorii = calorii;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setPicant(Boolean picant) {
        this.picant = picant;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setBucatarie(String bucatarie) {
        this.bucatarie = bucatarie;
    }

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

    protected Mancare(Parcel in) {
        Denumire = in.readString();
        calorii = in.readInt();
        vegetarian = in.readByte() != 0;
        tip = in.readString();
        byte tmpPicant = in.readByte();
        picant = tmpPicant == 0 ? null : tmpPicant == 1;
        rating = in.readFloat();
        bucatarie = in.readString();
    }

    public static final Creator<Mancare> CREATOR = new Creator<Mancare>() {
        @Override
        public Mancare createFromParcel(Parcel in) {
            return new Mancare(in);
        }

        @Override
        public Mancare[] newArray(int size) {
            return new Mancare[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Denumire);
        dest.writeInt(calorii);
        dest.writeByte((byte) (vegetarian ? 1 : 0));
        dest.writeString(tip);
        dest.writeByte((byte) (picant == null ? 0 : picant ? 1 : 2));
        dest.writeFloat(rating);
        dest.writeString(bucatarie);
    }
}
