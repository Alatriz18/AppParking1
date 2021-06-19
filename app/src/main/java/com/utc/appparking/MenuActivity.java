package com.utc.appparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void cerrarSesion(View vista) {
        // Guardar en un SHARED PREFERENCES
        SharedPreferences preferencias = getSharedPreferences("sesion_usuario", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("estado_usu", null);
        // Confirmar cambios del share prerences
        editor.commit();
        finish();
        Intent login = new Intent(getApplicationContext(), MainActivity.class);
        // Abrir la nueva pantall
        startActivity(login);
    }
    public void menupEspacio(View vista) {
        // Creando un Intent para invocar a RegisterActivity
        // Intent sirve para instanciar las nuevas actividades
        Intent menuEspacio = new Intent(getApplicationContext(), menu1.class);
        // Abrir la nueva pantall
        startActivity(menuEspacio);
    }

    //Proceso
    public void menupEntrada(View vista) {
        // Creando un Intent para invocar a RegisterActivity
        // Intent sirve para instanciar las nuevas actividades
        Intent menuEntrada = new Intent(getApplicationContext(), menu2.class);
        // Abrir la nueva pantall
        startActivity(menuEntrada);
    }

    //Proceso
    public void menupFacturacion(View vista) {
        // Creando un Intent para invocar a RegisterActivity
        // Intent sirve para instanciar las nuevas actividades
        Intent menuFacturacion = new Intent(getApplicationContext(), menu3.class);
        // Abrir la nueva pantall
        startActivity(menuFacturacion);
}

    public void cerrarPantallaMenu(View vista){

        finish();//cierra pantalla Menu opciones.
    }

}