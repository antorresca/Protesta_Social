package com.pruebas.protesta_social.logic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.objetos.Mensaje;

import java.util.List;

public class Contenedor extends RecyclerView.Adapter<Contenedor.ContendorDeMensaje> {

    private List<Mensaje> ListMensajes;

    public Contenedor(List<Mensaje> listMensajes) {
        ListMensajes = listMensajes;
    }

    @NonNull
    @Override
    public ContendorDeMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mensaje,parent,false);
        return new ContendorDeMensaje(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContendorDeMensaje holder, int position) {
        holder.Nombre.setText(ListMensajes.get(position).getName());
        holder.Mensaje.setText(ListMensajes.get(position).getMensaje());
        holder.Hora.setText(ListMensajes.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ContendorDeMensaje extends RecyclerView.ViewHolder{

        private TextView Nombre,Mensaje,Hora;

        public ContendorDeMensaje(@NonNull View itemView) {
            super(itemView);
            Nombre = (TextView) itemView.findViewById(R.id.Nombre_msj);
            Mensaje = (TextView) itemView.findViewById(R.id.Mensaje_msj);
            Mensaje = (TextView) itemView.findViewById(R.id.Hora_msj);

        }
    }
}
