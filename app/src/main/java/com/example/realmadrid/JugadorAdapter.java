package com.example.realmadrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorAdapter.JugadorViewHolder> {

    Context contexto;
    List<Jugador> listaJugadores;

    public JugadorAdapter(Context contexto, List<Jugador> listaJugadores) {
        this.contexto = contexto;
        this.listaJugadores = listaJugadores;
    }

    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(contexto).inflate(R.layout.item_jugador, parent, false);
        return new JugadorViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {
        Jugador jugador = listaJugadores.get(position);
        holder.txtNombre.setText(jugador.nombre);
        holder.txtPosicion.setText(jugador.posicion);
        holder.txtDorsal.setText(jugador.dorsal);
        if (jugador.url != null && !jugador.url.isEmpty()) {
            Picasso.with(contexto).load(jugador.url).into(holder.imgJugador);
        }
    }

    @Override
    public int getItemCount() {
        return listaJugadores.size();
    }

    public static class JugadorViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgJugador;
        TextView txtNombre;
        TextView txtPosicion;
        TextView txtDorsal;

        public JugadorViewHolder(@NonNull View itemView) {
            super(itemView);
            imgJugador = itemView.findViewById(R.id.imgJugador);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPosicion = itemView.findViewById(R.id.txtPosicion);
            txtDorsal = itemView.findViewById(R.id.txtDorsal);
        }
    }
}
