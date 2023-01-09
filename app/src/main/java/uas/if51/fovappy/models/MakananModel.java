package uas.if51.fovappy.models;

public class MakananModel {
    private String nama_makanan, deskripsi;
    private int id_makanan, harga,id_restaurant;

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getId_makanan() {
        return id_makanan;
    }

    public void setId_makanan(int id_makanan) {
        this.id_makanan = id_makanan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }
}
