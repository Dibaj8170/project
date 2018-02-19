package com.example.dibby.bebek.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dibby.bebek.R;
import com.example.dibby.bebek.db.DatabaseHandler;
import com.example.dibby.bebek.fragment.detailPenyakit.FragmentPenjelasan;
import com.example.dibby.bebek.pojo.Penyakit;
import com.example.dibby.bebek.util.CustomAdapter;
import com.example.dibby.bebek.util.CustomAdapterPenyakit;

import java.util.ArrayList;
import java.util.List;

public class PenyakitBebek extends AppCompatActivity implements AdapterView.OnItemClickListener {

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
        customList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Penyakit penyakit = penyakits.get(i);

//        Bundle bundle = new Bundle();
//        bundle.putString("eek",penyakit.getJelas());
        //Toast.makeText(this, "eek" + penyakit.getJelas(), Toast.LENGTH_SHORT).show();
        //FragmentPenjelasan fragmentPenjelasan = new FragmentPenjelasan();
        //fragmentPenjelasan.setArguments(bundle);

        Intent intent = new Intent(this, DetailPenyakit.class);
        intent.putExtra("jelas", penyakit.getJelas());
        intent.putExtra("ular", penyakit.getCegah());
        intent.putExtra("olu", penyakit.getSolusi());
        startActivity(intent);
    }
}
