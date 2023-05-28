package com.ervr.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    private TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvDatos = findViewById(R.id.tvDatos);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String correo = intent.getStringExtra("correo");
        String contraseña = intent.getStringExtra("contraseña");

        String datos = "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Correo: " + correo + "\n" +
                "Contraseña: " + contraseña;

        tvDatos.setText(datos);
    }
}
