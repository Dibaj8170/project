package com.dibby.bebek.pojo;

/**
 * Created by dibby on 14/02/2018.
 */

public class Gejala {
    //private variables
    String id;
    double angka;
    String nama;

    // Empty constructor
    public Gejala(){

    }
    // constructor
    public Gejala(String id, String nama, double angka){
        this.id = id;
        this.nama = nama;
        this.angka = angka;
    }

    // constructor
    public Gejala(String nama, double angka){
        this.nama = nama;
        this.angka = angka;
    }

    public Gejala(double angka){
        this.angka = angka;
    }
    // getting ID
    public String getID(){
        return this.id;
    }

    // setting id
    public void setID(String id){
        this.id = id;
    }

    // getting name
    public String getNama(){
        return this.nama;
    }

    // setting name
    public void setNama(String nama){
        this.nama = nama;
    }

    // getting ID
    public Double getAngka(){
        return this.angka;
    }

    // setting id
    public void setAngka(double angka){
        this.angka = angka;
    }
}
