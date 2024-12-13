package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    // Declaração dos campos
    EditText nome, emailCadastro, senhaCadastro, confirmarSenha;
    Button btnCadastrar;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);  // Este é o layout para a tela de cadastro

        // Inicializando os campos de entrada e botões
        nome = findViewById(R.id.nome);
        emailCadastro = findViewById(R.id.emailCadastro);
        senhaCadastro = findViewById(R.id.senhaCadastro);
        confirmarSenha = findViewById(R.id.confirmarSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        txtLogin = findViewById(R.id.txtLogin);

        // Configuração do clique no botão de cadastro
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = nome.getText().toString();
                String email = emailCadastro.getText().toString();
                String senha = senhaCadastro.getText().toString();
                String senhaConfirmada = confirmarSenha.getText().toString();

                // Validação dos campos
                if (nomeUsuario.isEmpty() || email.isEmpty() || senha.isEmpty() || senhaConfirmada.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
                } else if (!senha.equals(senhaConfirmada)) {
                    Toast.makeText(CadastroActivity.this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                } else {
                    // Se o cadastro for bem-sucedido, mostramos uma mensagem e redirecionamos para a tela de login
                    // Aqui você pode adicionar o processo de cadastro no banco de dados, se necessário

                    Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();

                    // Redireciona para a tela de login
                    Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();  // Finaliza a tela de cadastro para que o usuário não consiga voltar a ela
                }
            }
        });

        // Link para a tela de login
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();  // Finaliza a tela de cadastro
            }
        });
    }
}
