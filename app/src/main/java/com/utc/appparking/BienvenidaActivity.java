package com.utc.appparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        // Inicializamos SharePreferences

        SharedPreferences preferences = getSharedPreferences("sesion_usuario", Context.MODE_PRIVATE);
        String estado = preferences.getString("estado_usu", "");

        // Toast.makeText(getApplicationContext(), estado, Toast.LENGTH_LONG).show();
        // Comprobar si tiene datos almacenados para mantener activado el checkbox caso contrario desactivar
        if (!estado.isEmpty()) {
            // Crear un hilo
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent ventantaMenu = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(ventantaMenu);
                    finish();
                }
            }, 4000);
        } else {
            // Crear un hilo
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent ventantaLogin = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(ventantaLogin);
                    finish();
                }
            }, 4000);
        }


    }
}