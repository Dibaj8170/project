package com.example.dibby.bebek.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.dibby.bebek.R;
import com.example.dibby.bebek.fragment.detailPenyakit.FragmentPenjelasan;
import com.example.dibby.bebek.fragment.detailPenyakit.FragmentPenularan;
import com.example.dibby.bebek.fragment.detailPenyakit.FragmentSolusi;
import com.example.dibby.bebek.util.ViewPagerAdapter;

public class DetailPenyakit extends AppCompatActivity {

    String eek, tai, kucing;
    int tes;

    ImageView ivDetail;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        ViewPager viewPager = findViewById(R.id.detail_penyakit_view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        ivDetail = findViewById(R.id.detail_penyakit_gambar);

        Bundle bundle = getIntent().getExtras();
        eek = bundle.getString("jelas");
        tai = bundle.getString("ular");
        kucing  = bundle.getString("olu");
        tes = getIntent().getIntExtra("tes", 0);

        ivDetail.setImageResource(gambar[tes]);


        Log.i("cek", "dPenyakit = " + eek);
        // Add Fragments to adapter one by one
        adapter.addFragment(new FragmentPenjelasan(), "Penjelasan");
        adapter.addFragment(new FragmentPenularan(), "Pencegahan");
        adapter.addFragment(new FragmentSolusi(), "Solusi");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.detail_penyakit_tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    public String getJelas() {return eek;}
    public String getCegah() {return tai;}
    public String getSolusi() {return kucing;}
}
