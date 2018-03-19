package com.dibby.bebek.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dibby.bebek.R;
import com.dibby.bebek.db.DatabaseHandler;
import com.dibby.bebek.pojo.Penyakit;
import com.dibby.bebek.util.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class PenyakitBebek extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Penyakit> penyakits;
    ListView customList;
    Integer[] gambar = {
            R.drawable.snot,
            R.drawable.kapur,
            R.drawable.hijau2,
            R.drawable.kolera,
            R.drawable.cr,
            R.drawable.colibaci,
            R.drawable.nd,
            R.drawable.gumuro,
            R.drawable.ib,
            R.drawable.avian,
            R.drawable.marek,
            R.drawable.darah,
    };
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
            penyakits.add(new Penyakit(cn.getNo(), cn.getName(), cn.getJelas(),
                    cn.getCegah(), cn.getSolusi()));
        }

        customAdapter = new CustomAdapter(penyakits, getApplicationContext(), gambar);

        customList.setAdapter(customAdapter);
        customList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Penyakit penyakit = penyakits.get(i);

        Intent intent = new Intent(this, DetailPenyakit.class);
        intent.putExtra("jelas", penyakit.getJelas());
        intent.putExtra("ular", penyakit.getCegah());
        intent.putExtra("olu", penyakit.getSolusi());
        intent.putExtra("tes", i);
        startActivity(intent);
    }
}
