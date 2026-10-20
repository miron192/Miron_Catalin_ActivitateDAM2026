package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle b = getIntent().getExtras();
        int v1 = 0, v2 = 0;
        if (b != null) {
            String mesaj = b.getString("mesaj");
            v1 = b.getInt("valoare1");
            v2 = b.getInt("valoare2");
            Toast.makeText(this, mesaj + " | " + v1 + ", " + v2,
                    Toast.LENGTH_LONG).show();
        }

        final int suma = v1 + v2;
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent rezultat = new Intent();
            rezultat.putExtra("mesajRaspuns", "Salut din activitatea 3!");
            rezultat.putExtra("suma", suma);
            setResult(RESULT_OK, rezultat);
            finish();
        });
    }
}