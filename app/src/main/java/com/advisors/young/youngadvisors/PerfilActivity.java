package com.advisors.young.youngadvisors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String  Nombre, Apellidos, Correo, Telefono, Usuario, Password, Respuesta1, Respuesta2, Pregunta1, Pregunta2;
    TextView bienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Intent intent = getIntent();
        Nombre = intent.getStringExtra(RegistrarActivity.INombre);
        Apellidos = intent.getStringExtra(RegistrarActivity.IApellidos);
        Correo = intent.getStringExtra(RegistrarActivity.ICorreo);
        Telefono = intent.getStringExtra(RegistrarActivity.ITelefono);
        Usuario = intent.getStringExtra(RegistrarActivity.IUsuario);
        Password = intent.getStringExtra(RegistrarActivity.IPassword);
        Pregunta1 = intent.getStringExtra(RegistrarActivity.IPregunta1);
        Respuesta1 = intent.getStringExtra(RegistrarActivity.IRespuesta1);
        Pregunta2 = intent.getStringExtra(RegistrarActivity.IPregunta2);
        Respuesta2 = intent.getStringExtra(RegistrarActivity.IRespuesta2);

        bienvenido = findViewById(R.id.TVBienvenido);
        bienvenido.append(" " + Nombre);
    }
}
