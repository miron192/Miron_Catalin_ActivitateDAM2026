package com.example.sem4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;


public class MancareAdapter extends BaseAdapter {


    private List<Mancare> mancareList;
    private Context ctx;
    private int layout;

    public MancareAdapter(List<Mancare> mancareList, Context ctx, int layout) {
        this.mancareList = mancareList;
        this.ctx = ctx;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return mancareList.size();
    }

    @Override
    public Object getItem(int position) {
        return mancareList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(layout,parent, false);

        TextView denumireTV = v.findViewById(R.id.denumireTV);
        TextView caloriiTV = v.findViewById(R.id.caloriiTV);
        TextView tipTV = v.findViewById(R.id.tipTV);
        TextView ratingTV = v.findViewById(R.id.ratingTV);
        CheckBox vegetarianCB = v.findViewById(R.id.vegetarianCB);

        Mancare mancare = (Mancare)getItem(position);
        denumireTV.setText(mancare.getDenumire());
        caloriiTV.setText(String.valueOf(mancare.getCalorii()));
        tipTV.setText(mancare.getTip());
        ratingTV.setText(String.valueOf(mancare.getRating()));
        vegetarianCB.setChecked(mancare.isVegetarian());


        return v;
    }
}
