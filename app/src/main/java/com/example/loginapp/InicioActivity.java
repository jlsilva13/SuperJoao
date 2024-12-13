package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InicioActivity extends AppCompatActivity {

    ArrayList<Bebida> listaBebidas = new ArrayList<>();

    // Declaração dos botões
    Button btnAdicionarBebida, btnConsultarEstoque, btnRelatorioEstoque, btnExcluirBebida, btnEditarBebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);  // Layout para a tela de início

        // Inicializando a lista de bebidas
        Bebida novaBebida = new Bebida("Cerveja", 10, 5.50);
        listaBebidas.add(novaBebida);  // Adiciona a nova bebida à lista

        // Inicializando os botões
        btnAdicionarBebida = findViewById(R.id.btnAdicionarBebida);
        btnConsultarEstoque = findViewById(R.id.btnConsultarEstoque);
        btnRelatorioEstoque = findViewById(R.id.btnRelatorioEstoque);
        btnExcluirBebida = findViewById(R.id.btnExcluirBebida);
        btnEditarBebida = findViewById(R.id.btnEditarBebida);

        // Ação do botão "Adicionar Bebida"
        btnAdicionarBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this, AdicionarBebidaActivity.class);
                startActivity(intent);
                Toast.makeText(InicioActivity.this, "Adicionar Bebida", Toast.LENGTH_SHORT).show();
            }
        });

        // Ação do botão "Consultar Estoque"
        btnConsultarEstoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redireciona para a nova tela de consultar estoque
                Intent intent = new Intent(InicioActivity.this, ConsultarEstoqueActivity.class);
                intent.putExtra("listaBebidas", listaBebidas);  // Passa a lista de bebidas para a nova tela
                startActivity(intent);
            }
        });

        // Outras ações...
    }
}
