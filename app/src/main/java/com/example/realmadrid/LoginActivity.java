package com.example.realmadrid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsuario, edtContrasena;
    Button btnIngresar;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("sesion", MODE_PRIVATE);

        String usuarioGuardado = prefs.getString("usuario", "");
        if (!usuarioGuardado.isEmpty()) {
            irAInicio();
            return;
        }

        setContentView(R.layout.activity_login);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtContrasena = findViewById(R.id.edtContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });
    }

    private void entrar() {
        String usuario = edtUsuario.getText().toString();
        String contrasena = edtContrasena.getText().toString();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Por favor llenar los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!usuario.equals("yorlan") || !contrasena.equals("12345678")) {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("usuario", usuario);
        editor.apply();

        irAInicio();
    }

    private void irAInicio() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
