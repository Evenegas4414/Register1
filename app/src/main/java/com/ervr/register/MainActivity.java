package com.ervr.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etApellido, etCorreo, etContraseña;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    String nombre = etNombre.getText().toString();
                    String apellido = etApellido.getText().toString();
                    String correo = etCorreo.getText().toString();
                    String contraseña = etContraseña.getText().toString();

                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellido", apellido);
                    intent.putExtra("correo", correo);
                    intent.putExtra("contraseña", contraseña);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validarCampos() {
        String nombre = etNombre.getText().toString().trim();
        String apellido = etApellido.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String contraseña = etContraseña.getText().toString().trim();

        if (TextUtils.isEmpty(nombre)) {
            etNombre.setError("Por favor, ingresa un nombre.");
            mostrarMensaje("Por favor, ingresa un nombre.");
            return false;
        }

        if (TextUtils.isEmpty(apellido)) {
            etApellido.setError("Por favor, ingresa un apellido.");
            mostrarMensaje("Por favor, ingresa un apellido.");
            return false;
        }

        if (TextUtils.isEmpty(correo)) {
            etCorreo.setError("Por favor, ingresa un correo electrónico.");
            mostrarMensaje("Por favor, ingresa un correo electrónico.");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Por favor, ingresa un correo electrónico válido.");
            mostrarMensaje("Por favor, ingresa un correo electrónico válido.");
            return false;
        }

        if (TextUtils.isEmpty(contraseña)) {
            etContraseña.setError("Por favor, ingresa una contraseña.");
            mostrarMensaje("Por favor, ingresa una contraseña.");
            return false;
        } else if (contraseña.length() < 6) {
            etContraseña.setError("La contraseña debe tener al menos 6 caracteres.");
            mostrarMensaje("La contraseña debe tener al menos 6 caracteres.");
            return false;
        }

        return true;
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}