package co.edu.unab.hernandez.yeison.parcialapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.edu.unab.hernandez.yeison.parcialapp.modelos.Plato;

class PlatosAdapter extends RecyclerView.Adapter {
    ArrayList<Plato> platos ;
    Context context;

    public PlatosAdapter(ArrayList<Plato> platos, Context applicationContext) {
    this.platos= platos;
    this.context= applicationContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemplatos,parent,false);
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final Plato plato= platos.get(position);
        viewHolder.nombre.setText(plato.getNombrePlato());
        viewHolder.detalle.setText(context.getString(R.string.precio)+String.valueOf(plato.getPrecioPlato()));
        Picasso.get().load(plato.getFotoPlato()).into(viewHolder.imageView);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetallePlato.class);
                intent.putExtra("Plato",platos.get(position));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }
    class  ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView nombre,detalle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.fotoplato);
            cardView= itemView.findViewById(R.id.mycard);
            nombre= itemView.findViewById(R.id.nombreplato);
            detalle= itemView.findViewById(R.id.detalleplato);

        }
    }

    @Override
    public int getItemCount() {
        return platos.size();
    }
}
