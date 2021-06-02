package com.utc.appparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/*
@utor: EnmaMarqui
@utor: KevinSantana
creado: 16/05/2021
modificado: 18/05/2021
descripcion: ventana  de inicio de sesion acceso, crear cuenta para parueadero
 */

public class MainActivity extends AppCompatActivity {

    //Entrada
    EditText loginEmail, loginClave;     //creo objetos
    BaseDatos bdd;//creo objetito tipo bdd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //proceso 1 mapeo de elementos Xml a objetos JAVA
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginClave = (EditText) findViewById(R.id.loginClave);
        bdd=new BaseDatos(getApplicationContext());
    }

    //proceso2
    public void abrirPantallaRegistro(View vista){
        Intent pantallaRegistrar = new Intent(getApplicationContext(),activity_registro.class);//item para invocar el registro
        startActivity(pantallaRegistrar);//abrir pantalla registrar

    }
    //proceso 3

}