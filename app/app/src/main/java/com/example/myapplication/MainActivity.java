package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    private static final String TAG = "CICLU_VIATA";

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart - error");
        Log.w(TAG, "onStart - warning");
        Log.d(TAG, "onStart - debug");
        Log.i(TAG, "onStart - info");
        Log.v(TAG, "onStart - verbose");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume - error");
        Log.w(TAG, "onResume - warning");
        Log.d(TAG, "onResume - debug");
        Log.i(TAG, "onResume - info");
        Log.v(TAG, "onResume - verbose");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause - error");
        Log.w(TAG, "onPause - warning");
        Log.d(TAG, "onPause - debug");
        Log.i(TAG, "onPause - info");
        Log.v(TAG, "onPause - verbose");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop - error");
        Log.w(TAG, "onStop - warning");
        Log.d(TAG, "onStop - debug");
        Log.i(TAG, "onStop - info");
        Log.v(TAG, "onStop - verbose");
    }
}