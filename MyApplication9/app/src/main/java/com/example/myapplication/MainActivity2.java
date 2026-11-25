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

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Button btn = findViewById(R.id.miron_catalin_salveazaBTN);
        EditText et = findViewById(R.id.miron_catalin_modelET);
        CheckBox cb = findViewById(R.id.miron_catalin_5gCB);
        Spinner sp = findViewById(R.id.miron_catalin_memorieSP);

        btn.setOnClickListener(v -> {
            String model = et.getText().toString();
            Boolean retea = cb.isChecked();
            int memorie = Integer.parseInt(sp.getSelectedItem().toString().replace("GB",""));

           Bundle bundle = new Bundle();
           bundle.putSerializable("tableta",new Tableta(model,memorie,retea));
           Intent rezultat = new Intent();
           rezultat.putExtras(bundle);
           setResult(RESULT_OK, rezultat);
           finish();
        });
    }
}