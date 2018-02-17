package com.example.dibby.bebek.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.dibby.bebek.R;
import com.example.dibby.bebek.db.DatabaseHandler;
import com.example.dibby.bebek.pojo.Gejala;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Gejala(51,"Ravi", "9100000000"));
        db.addContact(new Gejala(52,"Srinivas", "9199999999"));
        db.addContact(new Gejala(53,"Tommy", "9522222222"));
        db.addContact(new Gejala(54,"Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Gejala> contacts = db.getAllContacts();

        for (Gejala cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
