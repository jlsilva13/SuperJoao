package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns; // Importando para validar o formato do email

public class LoginActivity extends AppCompatActivity {

    // Declaração dos campos
    EditText email, senha;
    Button btnLogin;
    TextView txtCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Este é o layout para a tela de login

        // Inicializando os campos de entrada e botões
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        btnLogin = findViewById(R.id.btnLogin);
        txtCadastrar = findViewById(R.id.txtCadastrar);

        // Configuração do clique no botão de login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUsuario = email.getText().toString();
                String senhaUsuario = senha.getText().toString();

                // Validação dos campos
                if (emailUsuario.isEmpty() || senhaUsuario.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Email e senha são obrigatórios", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(emailUsuario)) {
                    // Valida se o email tem o formato correto
                    Toast.makeText(LoginActivity.this, "Email inválido", Toast.LENGTH_SHORT).show();
                } else if (senhaUsuario.length() < 6) {
                    // Verifica se a senha tem no mínimo 6 caracteres
                    Toast.makeText(LoginActivity.this, "Senha deve ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show();
                } else {
                    // Aqui você pode fazer a validação do login. Por exemplo, verificar se os dados são válidos.
                    // Vamos assumir que o login foi bem-sucedido se os campos não estiverem vazios
                    // (Você pode adicionar um banco de dados ou qualquer outro método de autenticação)

                    // Exibe a mensagem de login bem-sucedido
                    Toast.makeText(LoginActivity.this, "Login bem-sucedido", Toast.LENGTH_SHORT).show();

                    // Redireciona para a próxima tela (por exemplo, a tela principal do aplicativo)
                    Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                    startActivity(intent);
                    finish();  // Finaliza a tela de login para não permitir voltar para ela
                }
            }
        });

        // Link para a tela de cadastro
        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish();  // Finaliza a tela de login para que o usuário não possa voltar a ela
            }
        });
    }

    // Método para validar o formato do email
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
