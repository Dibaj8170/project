package com.example.dibby.bebek.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dibby.bebek.R;

/**
 * Created by dibby on 19/02/2018.
 */

public class CustomAdapterPenyakit extends ArrayAdapter<String>{

    Activity context;
    String[] name;

    public CustomAdapterPenyakit(Activity context, String[] name){
        super(context, R.layout.list_penyakit ,name);

        this.context = context;
        this.name = name;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_penyakit, null, true);

        TextView tvNamaPenyakit = view.findViewById(R.id.name);

        tvNamaPenyakit.setText(name[position]);

        return view;
    }
}
