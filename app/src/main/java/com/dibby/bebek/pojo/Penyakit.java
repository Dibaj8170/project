package com.dibby.bebek.pojo;

/**
 * Created by dibby on 18/02/2018.
 */

public class Penyakit {
    //private variables
    String no;
    String name;
    String jelas;
    String cegah;
    String solusi;

    // Empty constructor
    public Penyakit(){

    }
    // constructor
    public Penyakit(String no, String name, String jelas, String cegah, String solusi) {
        this.no = no;
        this.name = name;
        this.jelas = jelas;
        this.cegah = cegah;
        this.solusi = solusi;
    }

    public Penyakit(String name, String jelas, String cegah, String solusi) {
        this.name = name;
        this.jelas = jelas;
        this.cegah = cegah;
        this.solusi = solusi;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJelas() {
        return jelas;
    }

    public void setJelas(String jelas) {
        this.jelas = jelas;
    }

    public String getCegah() {
        return cegah;
    }

    public void setCegah(String cegah) {
        this.cegah = cegah;
    }

    public String getSolusi() {
        return solusi;
    }

    public void setSolusi(String solusi) {
        this.solusi = solusi;
    }
}
