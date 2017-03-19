package com.kuena.kinket.arduino.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kuena.kinket.arduino.R;
import com.kuena.kinket.arduino.bean.Basic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by putra on 3/12/17.
 */

public class AdapterBasic extends BaseAdapter {
    private Context context;
    private ArrayList<Basic> list;
    private TextView judul;
    private ImageView image;
    private TextView code;
    private TextView alat;
    private TextView langkah;
    private TextView hasil;
    private LinearLayout llytLayout;
    String foto = "";
    public AdapterBasic(Context context, ArrayList<Basic> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.filter, parent, false);

        judul = (TextView) convertView.findViewById(R.id.judul);
        image = (ImageView) convertView.findViewById(R.id.image);
        llytLayout = (LinearLayout) convertView.findViewById(R.id.llyt_layout);

        judul.setText(list.get(position).getJudul());
        foto = list.get(position).getImage();
        Picasso.with(context)
                .load(foto)
                .resize(50, 50)
                .into(image);
        llytLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
/*
                    Intent intent=new Intent(context,isi_berita.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(config.TAG_JUDUL_BERITA,list.get(position).getJudul());
                    intent.putExtra(config.TAG_TANGGAL_BERITA, list.get(position).getTanggal());
                    intent.putExtra(config.TAG_ISI_BERITA, list.get(position).getIsi());
                    intent.putExtra(config.TAG_FOTO_BERITA, list.get(position).getFoto());
                    context.startActivity(intent);
  */
            }
        });

        return convertView;
    }
}
