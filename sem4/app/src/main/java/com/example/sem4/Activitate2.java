
package com.example.sem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activitate2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate2);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);

                    return insets;
                });
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
        boolean vegetarian = cbVegetarian.isChecked();

        int idSelectat = rgTip.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idSelectat);
        String tip = radioButton.getText().toString();

        float rating = rbRating.getRating();
        boolean picant = swPicant.isChecked();

        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        bundle.putString("denumire", denumire);
        bundle.putString("calorii", calorii);
        bundle.putBoolean("vegetarian", vegetarian);
        bundle.putString("tip", tip);
        bundle.putFloat("rating", rating);
        bundle.putBoolean("picant", picant);

        Spinner spBucatarie = findViewById(R.id.spBucatarie);
        bundle.putString("bucatarie", spBucatarie.getSelectedItem().toString());

        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
