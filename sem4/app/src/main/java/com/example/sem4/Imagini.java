package com.example.sem4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Imagini extends AppCompatActivity {


        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        List<Bitmap> imagini = new ArrayList<>();
        List<Poza> lista = new ArrayList<>();

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imagini);

        List<String> linkuri = new ArrayList<>();
        linkuri.add("https://commons.wikimedia.org/wiki/Special:FilePath/Pizza_food.jpg?width=600");
        linkuri.add("https://commons.wikimedia.org/wiki/Special:FilePath/Vegetarian_Pizza.jpg?width=600");
        linkuri.add("https://commons.wikimedia.org/wiki/Special:FilePath/Sushi1.jpg?width=600");
        linkuri.add("https://commons.wikimedia.org/wiki/Special:FilePath/Big_burger_at_Kuwait_food.jpg?width=600");
        linkuri.add("https://commons.wikimedia.org/wiki/Special:FilePath/Serbian_Christmas_meal.jpg?width=600");

        ListView lv = findViewById(R.id.imaginiLV);
        executor.execute(new Runnable() {
        @Override
        public void run(){
            for( String link:linkuri){
                HttpURLConnection con;
                try{
                    URL url = new URL(link);
                    con = (HttpURLConnection) url.openConnection();
                    con.setRequestProperty("User-Agent", "LabAndroid/1.0");
                    InputStream is = con.getInputStream();
                    imagini.add(BitmapFactory.decodeStream(is));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    lista = new ArrayList<>();
                    lista.add(new Poza("Pizza", imagini.get(0), "https://ro.wikipedia.org/wiki/Pizza"));
                    lista.add(new Poza("Pizza vegetariana", imagini.get(1), "https://ro.wikipedia.org/wiki/Pizza"));
                    lista.add(new Poza("Sushi", imagini.get(2), "https://ro.wikipedia.org/wiki/Sushi"));
                    lista.add(new Poza("Burger", imagini.get(3), "https://ro.wikipedia.org/wiki/Hamburger"));
                    lista.add(new Poza("Masa sarbeasca", imagini.get(4), "https://ro.wikipedia.org/wiki/Bucătăria_sârbească"));

                    ImageAdapter adapter = new ImageAdapter(lista, Imagini.this, R.layout.layout_poza);
                    lv.setAdapter(adapter);
                }
            });
            }
        }
        );

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(Imagini.this, MainActivity2.class);
            intent.putExtra("link", lista.get(position).getLink());
            startActivity(intent);
        });

     }




}