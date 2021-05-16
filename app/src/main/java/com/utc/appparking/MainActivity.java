package com.utc.appparking;
/*
@utor: EnmaMarqui
@utor: KevinSantana
creado: 16/05/2021
modificado: 18/05/2021
descripcion: ventana  de inicio de sesion acceso, crear cuenta para parueadero
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirPantallaRegistro(View vista){
        Intent pantallaRegistrar = new Intent(getApplicationContext(),activity_registro.class);//item para invocar el registro
        startActivity(pantallaRegistrar);//abrir pantalla registrar

    }
}