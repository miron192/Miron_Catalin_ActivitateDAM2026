package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;

public class MainActivity2 extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        EditText et = findViewById(R.id.miron_catalin_modelET);

        Spinner sp = findViewById(R.id.miron_catalin_memoriiSP);

        CheckBox cb = findViewById(R.id.miron_catalin_androidCB);

        Button btn = findViewById(R.id.miron_catalin_salvareBTN);

        btn.setOnClickListener(v->{
            String model = et.getText().toString();
            int memorie = Integer.parseInt(sp.getSelectedItem().toString().replace("GB",""));
            Boolean android = cb.isChecked();
            Tableta t = new Tableta(model,memorie,android);

            Bundle bundle = new Bundle();
            bundle.putSerializable("tableta", (Serializable) t);

            Intent rezultat = new Intent();
            rezultat.putExtras(bundle);
            setResult(RESULT_OK, rezultat);
            finish();
        });
    }
}