package com.utc.appparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
@utor: EnmaMarqui
@utor: KevinSantana
creado: 16/05/2021
modificado: 18/05/2021
descripcion:Pantalla para registrar usuarios y almacenar en sqlite
 */
public class activity_registro extends AppCompatActivity {
    EditText txtApellidos, txtNombres, txtCorreo, txtIngreseClave, txtConfirmeClave, txtNumero, txtDireccion;
    BaseDatos miBase;

    //proceso 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtApellidos=(EditText)findViewById(R.id.txtApellidos);
        txtNombres=(EditText)findViewById(R.id.txtNombres);
        txtCorreo=(EditText)findViewById(R.id.txtCorreo);
        txtIngreseClave=(EditText)findViewById(R.id.txtIngreseClave);
        txtConfirmeClave=(EditText)findViewById(R.id.txtConfirmeClave);
        txtNumero=(EditText)findViewById(R.id.txtNumero);
        txtDireccion=(EditText)findViewById(R.id.txtDireccion);

        miBase=new BaseDatos(getApplicationContext());
    }

    //proceso(2) cerrar
    public void cerrarPantallaRegistro(View vista){
       finish();//cierra pantalla registro
    }

    //poroceso(3)
    public void registrarUsuario(View vista) {
        String apellidos = txtApellidos.getText().toString();
        String nombres = txtNombres.getText().toString();
        String email = txtCorreo.getText().toString();
        String password = txtIngreseClave.getText().toString();
        String passwordx = txtConfirmeClave.getText().toString();
        String telefono = txtNumero.getText().toString();
        String direccion = txtDireccion.getText().toString();

        /*if ((apellidos.equals("")) || (nombres.equals("")) || (email.equals("")) || (password.equals("")) || (passwordx.equals("")) || (telefono.equals("")) || (direccion.equals(""))) {
            Toast.makeText(activity_registro.this, "los campos deben estar llenos", Toast.LENGTH_SHORT).show();
        }
        if (password.length() < 6) {
            Toast.makeText(activity_registro.this, "La contraseña debe tener minimo 6 caracteres.", Toast.LENGTH_SHORT).show();// valida la contarseña tenga 6 caracteres
        }
        if (passwordx.length() < 6) {
            Toast.makeText(activity_registro.this, "La contraseña debe tener minimo 6 caracteres.", Toast.LENGTH_SHORT).show();// valida la contarseña tenga 6 caracteres
        }
         */


        if (password.equals(passwordx)) {
            miBase.registraUsuario(apellidos, nombres, email, password, telefono, direccion);
            Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }

    }
}