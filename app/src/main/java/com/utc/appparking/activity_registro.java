package com.utc.appparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/*
@utor: EnmaMarqui
@utor: KevinSantana
creado: 16/05/2021
modificado: 18/05/2021
descripcion:Pantalla para registrar usuarios y almacenar en sqlite
 */
public class activity_registro extends AppCompatActivity {
    //proceso 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    //proceso cerrar
    public void cerrarPantallaRegistro(View vista){
       finish();//cierra pantalla registro
    }
}