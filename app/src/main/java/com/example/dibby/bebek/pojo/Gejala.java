package com.example.dibby.bebek.pojo;

/**
 * Created by dibby on 14/02/2018.
 */

public class Gejala {
    //private variables
    int _id;
    int angka;
    String _name;
    String _phone_number;

    // Empty constructor
    public Gejala(){

    }
    // constructor
    public Gejala(int id,int angka, String name, String _phone_number){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }

    // constructor
    public Gejala(int angka,String name, String _phone_number){
        this._name = name;
        this._phone_number = _phone_number;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting ID
    public int getAngka(){
        return this._id;
    }

    // setting id
    public void setAngka(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this._phone_number;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }
}
