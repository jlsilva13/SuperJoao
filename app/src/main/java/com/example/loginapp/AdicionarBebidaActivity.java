package com.example.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdicionarBebidaActivity extends AppCompatActivity {

    // Declaração dos campos
    EditText nomeBebida, quantidadeBebida, precoBebida;
    Button btnSalvarBebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_bebida);  // Layout para a tela de adicionar bebida

        // Inicializando os campos de entrada e botão
        nomeBebida = findViewById(R.id.nomeBebida);
        quantidadeBebida = findViewById(R.id.quantidadeBebida);
        precoBebida = findViewById(R.id.precoBebida);
        btnSalvarBebida = findViewById(R.id.btnSalvarBebida);

        // Configuração do clique no botão de salvar bebida
        btnSalvarBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeBebida.getText().toString();
                String quantidade = quantidadeBebida.getText().toString();
                String preco = precoBebida.getText().toString();

                // Validação dos campos
                if (nome.isEmpty() || quantidade.isEmpty() || preco.isEmpty()) {
                    Toast.makeText(AdicionarBebidaActivity.this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
                } else {
                    // Salvar a bebida (Aqui você pode salvar em um banco de dados ou lista)
                    // Por enquanto, vamos exibir um Toast
                    Toast.makeText(AdicionarBebidaActivity.this, "Bebida adicionada com sucesso!", Toast.LENGTH_SHORT).show();

                    // Voltar para a tela principal
                    finish();
                }
            }
        });
    }
}
