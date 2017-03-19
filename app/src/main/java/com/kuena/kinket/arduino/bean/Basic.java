package com.kuena.kinket.arduino.bean;

import java.io.Serializable;

/**
 * Created by putra on 3/12/17.
 */

public class Basic implements Serializable {


    public Basic() {
    }

    public Basic(String alat_bahan, String code, String hasil, String image, String judul, String langkah) {
        this.alat_bahan = alat_bahan;
        this.code = code;
        this.hasil = hasil;
        this.image = image;
        this.judul = judul;
        this.langkah = langkah;
    }

    public String getAlat_bahan() {
        return alat_bahan;
    }

    public void setAlat_bahan(String alat_bahan) {
        this.alat_bahan = alat_bahan;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLangkah() {
        return langkah;
    }

    public void setLangkah(String langkah) {
        this.langkah = langkah;
    }

    private String alat_bahan;
    private String code;
    private String hasil;
    private String image;
    private String judul;
    private String langkah;


}
