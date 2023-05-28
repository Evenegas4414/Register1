package com.ervr.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ervr.register.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.etNombre.getText().toString().trim();
                String apellido = binding.etApellido.getText().toString().trim();
                String correo = binding.etCorreo.getText().toString().trim();
                String contrasena = binding.etContraseA.getText().toString().trim();

                if (TextUtils.isEmpty(nombre)) {
                    binding.etNombre.setError("Ingrese su nombre");
                    return;
                }

                if (TextUtils.isEmpty(apellido)) {
                    binding.etApellido.setError("Ingrese su apellido");
                    return;
                }

                if (TextUtils.isEmpty(correo)) {
                    binding.etCorreo.setError("Ingrese su correo electrónico");
                    return;
                }

                if (TextUtils.isEmpty(contrasena)) {
                    binding.etContraseA.setError("Ingrese su contraseña");
                    return;
                }

                // Crear el Intent para abrir la actividad DisplayActivity
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                // Pasar los datos a través del Intent utilizando extras
                intent.putExtra("nombre", nombre);
                intent.putExtra("apellido", apellido);
                intent.putExtra("correo", correo);
                intent.putExtra("contraseña", contrasena);
                // Iniciar la actividad DisplayActivity
                startActivity(intent);
            }
        });
    }
}
