package co.edu.unab.hernandez.yeison.parcialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import co.edu.unab.hernandez.yeison.parcialapp.modelos.Plato;

public class DetallePlato extends AppCompatActivity {
    private TextView nombre, detalle, cantidad, precio, total;
    private ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Plato plato = (Plato) getIntent().getSerializableExtra("Plato");
        setContentView(R.layout.activity_detalle_plato);
        setTitle(getString(R.string.title));
        nombre= findViewById(R.id.nombre);
        detalle= findViewById(R.id.detalle);
        cantidad= findViewById(R.id.cantidad);
        precio= findViewById(R.id.precio);
        total= findViewById(R.id.total);
        foto= findViewById(R.id.fotofinal);

        Picasso.get().load(plato.getFotoPlato()).into(foto);

        nombre.setText(plato.getNombrePlato());
        detalle.setText(plato.getDescripciónPlato());
        cantidad.setText(getString(R.string.signoNumero)+String.valueOf(plato.getCantidadPlato()));
        precio.setText(getString(R.string.precio)+String.valueOf(plato.getPrecioPlato()));
        total.setText(getString(R.string.total)+getString(R.string.precio)+plato.getPrecioPlato()*plato.getCantidadPlato());
    }
}
