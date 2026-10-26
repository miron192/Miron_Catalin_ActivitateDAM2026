
package com.example.sem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // primeste rezultatul de la Activitate2 / ActivitateAI
    private final ActivityResultLauncher<Intent> launcherMancare =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Bundle bundle = result.getData().getExtras();
                            if (bundle == null) {
                                return;
                            }

                            int calorii = 0;
                            try {
                                calorii = Integer.parseInt(bundle.getString("calorii", "0"));
                            } catch (NumberFormatException e) {
                                calorii = 0;
                            }

                            Mancare mancare = new Mancare(
                                    bundle.getString("denumire"),
                                    calorii,
                                    bundle.getBoolean("vegetarian"),
                                    bundle.getString("tip"),
                                    bundle.getBoolean("picant"),
                                    bundle.getFloat("rating"),
                                    bundle.getString("bucatarie"));

                            TextView tvRezultat = findViewById(R.id.tvRezultat);
                            tvRezultat.setText(mancare.toString());
                            Toast.makeText(this, mancare.toString(), Toast.LENGTH_LONG).show();
                        }
                    });

    public void deschideActivitateAI(View view) {
        Intent intent = new Intent(MainActivity.this, ActivitateAI.class);
        launcherMancare.launch(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    Button btnAdauga = findViewById(R.id.btnAdauga);

                    btnAdauga.setOnClickListener(v1 -> {
                        Intent intent = new Intent(
                                MainActivity.this, Activitate2.class);
                        launcherMancare.launch(intent);
                    });

                    return insets;
                });
    }

    public void culegeDate(View view) {
        EditText et = findViewById(R.id.nume_ET);
        CheckBox cb = findViewById(R.id.eStudent_CB);

        String nume = et.getText().toString();
        Boolean eStudent = cb.isChecked();
    }


    public void culegeDateMancare(View view) {
        EditText etDenumire = findViewById(R.id.etDenumire);
        EditText etCalorii = findViewById(R.id.etCalorii);
        CheckBox cbVegetarian = findViewById(R.id.cbVegetarian);
        RadioGroup rgTip = findViewById(R.id.rgTip);
        RatingBar rbRating = findViewById(R.id.rbRating);
        Switch swPicant = findViewById(R.id.swPicant);

        String denumire = etDenumire.getText().toString();
        String calorii = etCalorii.getText().toString();
        Boolean vegetarian = cbVegetarian.isChecked();

        int idSelectat = rgTip.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idSelectat);
        String tip = radioButton.getText().toString();

        float rating = rbRating.getRating();
        Boolean picant = swPicant.isChecked();
    }

}
