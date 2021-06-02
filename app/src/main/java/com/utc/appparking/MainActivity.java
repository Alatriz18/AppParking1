package com.utc.appparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
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
    BaseDatos bdd;//creo objeto tipo bdd

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
    public void iniciarSesion(View vista) {
        //capturar valores ingresados por el usuario
        String email = loginEmail.getText().toString();
        String password = loginClave.getText().toString();

        Cursor usuarioEncontrado = bdd.obtenerUsuarioPorEmailPassword(email, password);//hacer consultas uso de objeto cursor
        if (usuarioEncontrado != null) { //email y contraseña sean correctos se obtienn de la bdd

            String emailBdd = usuarioEncontrado.getString(3).toString();//get email almacenadoe en la BDD
            String nombresBdd = usuarioEncontrado.getString(2).toString();//mostramos la bienvenida
            Toast.makeText(getApplicationContext(),"Bienvenido"+nombresBdd,Toast.LENGTH_LONG).show();
            finish();//cierra el formulario de inicio de sesion

            Intent ventanaMenu =new Intent(getApplicationContext(), MenuActivity.class);//objeto para manejar la activity menu
            startActivity(ventanaMenu);

        } else {
            Toast.makeText(getApplicationContext(),"Email o clave erroneas",Toast.LENGTH_LONG).show();
            loginClave.setText("");//limpia campo contraseña
        }
    }
}