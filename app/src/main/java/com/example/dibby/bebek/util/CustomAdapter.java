package com.example.dibby.bebek.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dibby.bebek.R;
import com.example.dibby.bebek.pojo.Penyakit;

import java.util.ArrayList;

/**
 * Created by dibby on 19/02/2018.
 */

public class CustomAdapter extends ArrayAdapter<Penyakit> {

    private ArrayList<Penyakit> arrayList;
//    Integer[] gambar;
    Context context;

    private static class ViewHolder{
        TextView tvName;
//        ImageView ivPoto;
    }

    public CustomAdapter(ArrayList<Penyakit> data, Context context1/*, Integer[] gambar*/){
        super(context1, R.layout.list_penyakit, data);
        this.arrayList = data;
        this.context = context1;
//        this.gambar = gambar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Penyakit penyakit = getItem(position);
        ViewHolder viewHolder;

        final View view;

        if (convertView == null){

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_penyakit, parent, false);
            viewHolder.tvName = convertView.findViewById(R.id.name);
//            viewHolder.ivPoto = convertView.findViewById(R.id.detail_penyakit_gambar);

            view = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        viewHolder.tvName.setText(penyakit.getName());
//        viewHolder.ivPoto.setImageResource(gambar[position]);

        return convertView;
    }
}
