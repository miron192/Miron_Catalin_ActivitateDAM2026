package com.example.sem4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private List<Poza> listaPoze;
    private Context ctx;
    private int layout;

    public ImageAdapter(List<Poza> listaPoze, Context ctx, int layout) {
        this.listaPoze = listaPoze;
        this.ctx = ctx;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listaPoze.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPoze.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(layout, parent, false);

        ImageView imagineIV = v.findViewById(R.id.imagineIV);
        TextView textTV = v.findViewById(R.id.textTV);

        Poza poza = (Poza) getItem(position);
        imagineIV.setImageBitmap(poza.getImagine());
        textTV.setText(poza.getTextAfisat());

        return v;
    }
}
