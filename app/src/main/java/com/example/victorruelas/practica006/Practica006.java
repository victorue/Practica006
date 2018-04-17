package com.example.victorruelas.practica006;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Practica006 extends AppCompatActivity {

    private TextView txt;
    private ListView lista;
    private List<String> lProductos= new ArrayList<>();
    private List<String>lCategoria=new ArrayList<>();

    // DATOS CON LOS QUE SE LLENARA EL ListView

   /*-- private String productos[]={"Computadora", "Mouse", "Dulces", "Hojas", "Lapices", "Lentes", "Reloj",
            "Cuchara", "Celular", "Mesa", "Refrigerador", "Horno", "Audifonos"};

    private String catregoria[]={"Electronica", "Electronica", "Dulceria", "Papeleria", "Papeleria", "Moda", "Perfumeria",
            "Hogar", "Electronicos", "Hogar", "Electrodomesticos", "Electrodomesticos", "Electronica"};

    ----------*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica006);

        txt=(TextView)findViewById(R.id.txtView);
        lista= (ListView)findViewById(R.id.lista);
        actualizarTabla();



    }

    public void llamaActividad (View x){

        Intent i =new Intent(this,AgregarActividad.class);
        startActivityForResult(i,1000);
    }

    public void actualizarTabla(){

        String productos[]=new String[lProductos.size()];
        lProductos.toArray(productos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,productos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                txt.setText("Categoria elegida: " + lCategoria.get(position));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        lProductos.add(data.getStringExtra("nombre"));
        lCategoria.add(data.getStringExtra("categoria"));
        actualizarTabla();
    }
}
