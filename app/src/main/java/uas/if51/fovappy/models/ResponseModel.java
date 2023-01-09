package uas.if51.fovappy.models;

import java.util.List;

public class ResponseModel {
    private int kode;
    private String pesan;
    private List<DataModel> data;
    private List<MakananModel> makanan;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }

    public List<MakananModel> getMakanan() {
        return makanan;
    }

    public void setMakanan(List<MakananModel> makanan) {
        this.makanan = makanan;
    }
}
