package com.example.victorruelas.practica006;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AgregarActividad extends AppCompatActivity {

        private Spinner spnProducto;
        private EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);

        editTextNombre=(EditText)findViewById(R.id.editTextNombre);

        spnProducto = (Spinner) findViewById(R.id.spnProducto);

        String opciones[]={"Bebe", "Auto", "Electronicos", "Peliculas", "Ropa", "Zapatos", "Deportes",
                "Hogar", "Industria", "Juegos", "Libros", "Mascotas", "Musica"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        spnProducto.setAdapter(adapter);




        spnProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void agregar (View view){
        Intent i = new Intent();
        i.putExtra("nombre",editTextNombre.getText().toString());
        i.putExtra("categoria", spnProducto.getSelectedItem().toString());
        setResult(RESULT_OK,i);
        finish();

    }
}
