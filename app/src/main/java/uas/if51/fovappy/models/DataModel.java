package uas.if51.fovappy.models;

public class DataModel {
    private int id;
    private String nama_restaurant, rating, waktu, alamat, asal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_restaurant() {
        return nama_restaurant;
    }

    public void setNama_restaurant(String nama_restaurant) {
        this.nama_restaurant = nama_restaurant;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }
}
