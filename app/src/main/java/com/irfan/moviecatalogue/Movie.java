package com.irfan.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String nama;
    private String tglrilis;
    private String durasi;
    private String deskripsi;
    private String karakter;
    private String score;
    private int Foto;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTglrilis() {
        return tglrilis;
    }

    public void setTglrilis(String tglrilis) {
        this.tglrilis = tglrilis;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKarakter() {
        return karakter;
    }

    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.tglrilis);
        dest.writeString(this.durasi);
        dest.writeString(this.deskripsi);
        dest.writeString(this.karakter);
        dest.writeString(this.score);
        dest.writeInt(this.Foto);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.nama = in.readString();
        this.tglrilis = in.readString();
        this.durasi = in.readString();
        this.deskripsi = in.readString();
        this.karakter = in.readString();
        this.score = in.readString();
        this.Foto = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}