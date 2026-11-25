package com.example.myapplication;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ArrayList<Tableta> list = (ArrayList<Tableta>) getIntent().getSerializableExtra("list");


        ListView lv= findViewById(R.id.miron_catalin_rezLV);
        ArrayAdapter<Tableta> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(((parent, view, position, id) -> {
            Tableta t = list.get(position);
            Toast.makeText(MainActivity3.this, t.toString(), Toast.LENGTH_SHORT).show();
        }));

        lv.setOnItemLongClickListener(((parent, view, position, id) -> {
            Tableta t = list.get(position);
            t.setMemorie(t.getMemorie()-t.getMemorie()/10);
            adapter.notifyDataSetChanged();
            return true;
        }));
    }
}