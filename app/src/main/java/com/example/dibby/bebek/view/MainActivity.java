package com.example.dibby.bebek.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.example.dibby.bebek.R;
import com.example.dibby.bebek.db.DatabaseHandler;
import com.example.dibby.bebek.pojo.Gejala;
import com.example.dibby.bebek.pojo.Penyakit;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView btnBebek, btnPenyakit, btnDiagnosa, btnCaraBertenak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBebek = findViewById(R.id.main_button_bebek);
        btnPenyakit = findViewById(R.id.main_button_penyakit);
        btnDiagnosa = findViewById(R.id.main_button_diagnosa);
        btnCaraBertenak = findViewById(R.id.main_button_cara_bertenak);

        btnBebek.setOnClickListener(this);
        btnPenyakit.setOnClickListener(this);
        btnDiagnosa.setOnClickListener(this);
        btnCaraBertenak.setOnClickListener(this);

        DatabaseHandler db = new DatabaseHandler(this);

        db.onDelete();
        //*
        // * CRUD Operations
        // Inserting Contacts

        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Gejala("Ravi", "9100000000", 0.5));
        db.addContact(new Gejala("Srinivas", "9199999999",0.1));
        db.addContact(new Gejala("Tommy", "9522222222",0.2));
        db.addContact(new Gejala("Karthik", "9533333333",0.4));

        Log.d("Insert: ", "Inserting ..");
        db.addPenyakit(new Penyakit("dua", "Tiga", "empat", "lima"));
        db.addPenyakit(new Penyakit("enam", "Tuju", "delapan", "sembilan"));



        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Gejala> contacts = db.getAllContacts();

        for (Gejala cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getNama() + " ,Ket: " + cn.getKet()+" ,Angka: " + cn.getAngka() ;
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        Log.d("Reading: ", "Reading all contacts..");
        List<Penyakit> penyakits = db.getAllPenyakit();

        for (Penyakit cn : penyakits) {
            String log = "Id: "+cn.getNo()+" ,Name: " + cn.getName() + " ,Penjelasan: " + cn.getJelas()+" ,Pencegahan: " + cn.getCegah() + " ,Pengobatan: " + cn.getSolusi();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_button_bebek :
                startActivity(new Intent(this, TentangBebek.class));
                break;

            case R.id.main_button_penyakit :
                startActivity(new Intent(this, PenyakitBebek.class));
                break;

            case R.id.main_button_diagnosa :
                startActivity(new Intent(this, Diagnosa.class));
                break;

            case R.id.main_button_cara_bertenak :
                startActivity(new Intent(this, CaraBeternak.class));
                break;
        }
    }
}
