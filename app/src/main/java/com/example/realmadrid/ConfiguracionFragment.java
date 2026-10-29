package com.example.realmadrid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConfiguracionFragment extends Fragment {

    TextView txtNombreUsuario;
    Button btnCerrarSesion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_configuracion, container, false);

        txtNombreUsuario = vista.findViewById(R.id.txtNombreUsuario);
        btnCerrarSesion = vista.findViewById(R.id.btnCerrarSesion);

        final SharedPreferences prefs = requireActivity().getSharedPreferences("sesion", Context.MODE_PRIVATE);
        String usuario = prefs.getString("usuario", "");
        txtNombreUsuario.setText(usuario);

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                requireActivity().finish();
            }
        });

        return vista;
    }
}
