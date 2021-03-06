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

import static com.pruebas.protesta_social.ui.Login.NombreDeUsuario;

public class Contenedor extends RecyclerView.Adapter<Contenedor.ContendorDeMensaje> {

    private List<Mensaje> LstMensajes;

    public Contenedor(List<Mensaje> listMensajes) {
        this.LstMensajes = listMensajes;
    }

    @NonNull
    @Override
    public ContendorDeMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mensaje,parent,false);
        return new ContendorDeMensaje(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContendorDeMensaje holder, int position) {
        holder.Nombre.setText(LstMensajes.get(position).getName());
        holder.Mensaje.setText(LstMensajes.get(position).getMensaje());
        holder.Hora.setText(LstMensajes.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return LstMensajes.size();
    }

    class ContendorDeMensaje extends RecyclerView.ViewHolder{

        private TextView Mensaje,Hora,Nombre;

        public ContendorDeMensaje(@NonNull View itemView) {
            super(itemView);
            Nombre  = itemView.findViewById(R.id.Nombre_msj);
            Mensaje = itemView.findViewById(R.id.Mensaje_msj);
            Hora = itemView.findViewById(R.id.Hora_msj);

        }
    }
}
