package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle b = result.getData().getExtras();
                    if (b != null) {
                        String mesaj = b.getString("mesajRaspuns");
                        int suma = b.getInt("suma");
                        Toast.makeText(this, mesaj + " | Suma: " + suma,
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn = findViewById(R.id.btnOpenThird);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("mesaj", "Salut din activitatea 2!");
            bundle.putInt("valoare1", 7);
            bundle.putInt("valoare2", 5);
            intent.putExtras(bundle);
            launcher.launch(intent);
        });
    }
}