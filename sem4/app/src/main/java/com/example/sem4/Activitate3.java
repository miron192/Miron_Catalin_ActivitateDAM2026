package com.example.sem4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Activitate3 extends AppCompatActivity {

   private List<Mancare> lista = null;
    private int idModificat=0;
    private MancareAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate3);

        lista = (List<Mancare>) getIntent().getSerializableExtra("lista");

//        ArrayAdapter<Mancare> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        ListView lv = findViewById(R.id.lvMancaruri);
//        lv.setAdapter(adapter);

        adapter = new MancareAdapter(lista, getApplicationContext(),R.layout.layoutpersonalizatmancare);


        lv.setAdapter(adapter);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, lista.get(position).toString(), Toast.LENGTH_LONG).show();
        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            lista.remove(position);
            adapter.notifyDataSetChanged();

            Intent intent = new Intent();
            intent.putExtra("lista", new ArrayList<>(lista));
            setResult(RESULT_OK, intent);
            return true;
        });
    }
}
