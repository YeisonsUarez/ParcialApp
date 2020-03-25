package co.edu.unab.hernandez.yeison.parcialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.unab.hernandez.yeison.parcialapp.modelos.Plato;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Plato> platos;
    private RecyclerView list;
    private TextView totalVentas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= findViewById(R.id.myrec);
        totalVentas= findViewById(R.id.totalventas);
        setTitle(getString(R.string.title));
        agregarPlatos();
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplication());
        PlatosAdapter adapter= new PlatosAdapter(platos,getApplicationContext());
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
        totalVentas.setText(getString(R.string.fraseventas)+String.valueOf(calcularTotalVenta()));

    }




    public void agregarPlatos(){
        platos= new ArrayList<>();
        platos.add(new Plato("Bandeja Paisa","Bandeja Paisa es una comida tradicional de la región Paisa de Colombia, que incluye las ciudades de Medellín, Santa Fe de Antioquia, Guatape y Jardín. De hecho, es tan querida que ha sido adoptada como plato nacional de Colombia. Esta abundante comida usualmente contiene arroz blanco, frijoles rojos, carne molida o picada, plátano, chorizo, maíz, chicharrón de cerdo, huevo frito, arepa y un aguacate.","https://www.rappi.com.co/blog/wp-content/uploads/2018/10/receta-para-preparar-bandeja-paisa-colombiana.jpg",10,150000.0));
        platos.add(new Plato("Ajiaco","El ajiaco bogotano o santafereño es una sopa típica de la zona de Bogotá, Colombia.1\u200B Contiene pollo en presas o desmenuzado, papa criolla, pastusa y sabanera, mazorca de maíz y opcionalmente alcaparras y crema de leche.","https://www.vanguardia.com/binrepository/716x477/0c0/0d0/none/12204/CILQ/web_ajiaco_big_ce_VL430680_MG17870339.jpg",10,150000.0));
        platos.add(new Plato("CRISPY WRAP","Bañado en los exóticos sabores del curry y coco tailandés, este bollito crujiente, relleno de pollo y camarones, se sirve en un consomé de bonito, acompañado de col lombarda.","https://www.hotelmousai.com.mx/blog/wp-content/uploads/2016/08/crispy-wrap.jpg",20,53000.0));
        platos.add(new Plato("SOPA DE FLOR DE CALABAZA","Servido con una ronda de queso de cabra y chile ancho, esta sabrosa sopa de flor de calabaza se sirve con maíz y calabacín.","https://www.hotelmousai.com.mx/blog/wp-content/uploads/2016/08/sopa-de-flor-de-calabaza.jpg",34,45000.0));

    }

    public  double calcularTotalVenta(){
        double total=0;
        for (Plato plato: platos
             ) {

            total=  (total+(plato.getCantidadPlato()*plato.getPrecioPlato()));
        }
        return total;
    }
}
