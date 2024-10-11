package com.example.app_busmap;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private Button bt_entrar; // Adicionando a variável para o botão
    private EditText editUser; // Campo de Usuário
    private EditText editSenha; // Campo de Senha

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializando os componentes
        IniciarComponents();

        // Configurando o click listener para o text_tela_cadastro
        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, cadastro.class);
                startActivity(intent);
            }
        });

        // Configurando o click listener para o botão bt_entrar
        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pegando os valores de usuário e senha
                String usuario = editUser.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();

                // Verifica se o campo Usuário está vazio
                if (TextUtils.isEmpty(usuario)) {
                    editUser.setError("Usuário é obrigatório");
                    editUser.requestFocus();
                    return;
                }

                // Verifica se o campo Senha está vazio
                if (TextUtils.isEmpty(senha)) {
                    editSenha.setError("Senha é obrigatória");
                    editSenha.requestFocus();
                    return;
                }

                // Verifica se a senha contém pelo menos uma letra maiúscula, duas letras minúsculas, dois números e um caractere especial
                if (!senha.matches("^(?=.*[A-Z])(?=.*[a-z]{2})(?=.*[0-9]{2})(?=.*[@#$!]).+$")) {
                    editSenha.setError("A senha deve conter pelo menos uma letra maiúscula, duas letras minúsculas, dois números e um caractere especial(@#$!)");
                    editSenha.requestFocus();
                    return;
                }

                // Se passar pelas validações, chama a função para abrir a Home
                abrindo_home(view);
            }
        });
    }

    // Método para inicializar os componentes
    private void IniciarComponents() {
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
        bt_entrar = findViewById(R.id.bt_entrar); // Inicializando o botão
        editUser = findViewById(R.id.edit_user); // Inicializando o campo de usuário
        editSenha = findViewById(R.id.edit_senha); // Inicializando o campo de senha
    }

    // Método para abrir a Home Activity
    public void abrindo_home(View view) {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }

    // Método para abrir a tela de "Esqueci minha senha"
    public void abrindo_esqueci(View view) {
        Intent intent = new Intent(this, esquecisenha.class);
        startActivity(intent);
    }
}
