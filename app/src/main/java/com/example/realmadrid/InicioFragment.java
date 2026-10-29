package com.example.realmadrid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    RecyclerView recyclerJugadores;
    JugadorAdapter adapter;
    List<Jugador> listaJugadores;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_inicio, container, false);

        recyclerJugadores = vista.findViewById(R.id.recyclerJugadores);
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(getContext()));

        listaJugadores = new ArrayList<>();
        listaJugadores.add(new Jugador(
                "Kylian Mbappé",
                "Delantero",
                "9",
                "https://static.nmas.com.mx/Nmas/cms/real-madrid-vs-real-sociedad-la-liga-2026-1080x1080.jpg"
        ));
        listaJugadores.add(new Jugador(
                "Vinícius Jr.",
                "Extremo",
                "7",
                "https://images.daznservices.com/di/library/DAZN_News/b8/71/vinicius-real-madrid-2026_1wzv7flpuccy21rid6ywd5trfh.png?t=725658960"
        ));
        listaJugadores.add(new Jugador(
                "Jude Bellingham",
                "Mediocampista",
                "5",
                "https://www.somosfutbol.es/wp-content/uploads/2026/09/HRCXASUXoAEzqxi_11zon-e1788449824719.webp"
        ));
        listaJugadores.add(new Jugador(
                "Marc Cucurella",
                "Lateral izquierdo",
                "17",
                "https://cdn2.mediotiempo.com/uploads/media/2026/08/16/marc-cucurella-sentir-presentacion-conjunto.jpg"
        ));

        adapter = new JugadorAdapter(getContext(), listaJugadores);
        recyclerJugadores.setAdapter(adapter);

        return vista;
    }
}
