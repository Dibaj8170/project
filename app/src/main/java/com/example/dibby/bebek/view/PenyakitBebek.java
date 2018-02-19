package com.example.dibby.bebek.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.dibby.bebek.R;
import com.example.dibby.bebek.db.DatabaseHandler;
import com.example.dibby.bebek.pojo.Penyakit;
import com.example.dibby.bebek.util.CustomAdapter;
import com.example.dibby.bebek.util.CustomAdapterPenyakit;

import java.util.ArrayList;
import java.util.List;

public class PenyakitBebek extends AppCompatActivity {

    ArrayList<Penyakit> penyakits;
    ListView customList;
    public static CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit);

        customList = findViewById(R.id.list_view);

        penyakits = new ArrayList<>();

        DatabaseHandler db = new DatabaseHandler(this);
        List<Penyakit> hubla = db.getAllPenyakit();

        for (Penyakit cn : hubla) {
            /*String log = "Id: "+cn.getNo()+" ,Name: " + cn.getName() + " ,Penjelasan: " + cn.getJelas()+" ,Pencegahan: " + cn.getCegah() + " ,Pengobatan: " + cn.getSolusi();
            // Writing Contacts to log
            Log.d("Name: ", log);*/
            penyakits.add(new Penyakit(cn.getNo(), cn.getName(), cn.getJelas(),
                    cn.getCegah(), cn.getSolusi()));
        }

        customAdapter = new CustomAdapter(penyakits, getApplicationContext());

        customList.setAdapter(customAdapter);

    }
}
