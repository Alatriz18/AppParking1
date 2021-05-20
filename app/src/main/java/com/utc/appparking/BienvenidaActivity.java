package com.utc.appparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ventanalogin=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(ventanalogin);
                finish();

            }
        },4000);
    }
}