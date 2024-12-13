package com.example.loginapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ConsultarEstoqueActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Bebida> listaBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_estoque);  // Layout para consultar estoque

        // Recebe a lista de bebidas passada pela Intent
        listaBebidas = (ArrayList<Bebida>) getIntent().getSerializableExtra("listaBebidas");

        // Inicializando o ListView
        listView = findViewById(R.id.listView);

        // Criação do adaptador para preencher o ListView
        ArrayAdapter<Bebida> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaBebidas);
        listView.setAdapter(adapter);
    }
}
