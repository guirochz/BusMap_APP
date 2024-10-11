package com.example.app_busmap;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro extends AppCompatActivity {

    private EditText editNome, editUser, editEmail, editSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Referências para os EditTexts e o botão
        editNome = findViewById(R.id.edit_nome);
        editUser = findViewById(R.id.edit_user);
        editEmail = findViewById(R.id.edit_email);
        editSenha = findViewById(R.id.edit_senha);
        btnCadastrar = findViewById(R.id.btn_cadastrar);

        // Adiciona listeners para validações dos campos
        addValidationListeners();

        // Botão Cadastrar - chama a função abrircadastro se todos os campos forem válidos
        btnCadastrar.setOnClickListener(v -> {
            if (validateFields()) {
                cadastrar();
            }
        });
    }

    private void addValidationListeners() {
        // Validação para o campo Nome (somente letras)
        editNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                validateFields();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        // Validação para o campo Usuário (letras e números, sem caracteres especiais)
        editUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                validateFields();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        // Validação para o campo Email (obrigatório conter "@")
        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                validateFields();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        // Validação para o campo Senha (uma letra maiúscula, duas letras minúsculas, dois números, e pelo menos um caractere especial @#$!)
        editSenha.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                validateFields();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    private boolean validateFields() {
        // Validações para os campos
        String nome = editNome.getText().toString();
        String user = editUser.getText().toString();
        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        String regexNome = "^[A-Za-zÁ-ú\\s]+$"; // Apenas letras e espaços
        String regexUser = "^[A-Za-z0-9]+$"; // Letras e números
        String regexSenha = "^(?=.*[A-Z])(?=(.*[a-z]){2,})(?=(.*[0-9]){2,})(?=.*[@#$!]).{6,}$"; // Regras para senha

        boolean nomeValido = nome.matches(regexNome);
        boolean userValido = user.matches(regexUser);
        boolean emailValido = email.contains("@");
        boolean senhaValida = senha.matches(regexSenha);

        // Validação do nome
        if (!nomeValido) {
            editNome.setError("Nome deve conter apenas letras.");
        }

        // Validação do usuário
        if (!userValido) {
            editUser.setError("Usuário não pode conter caracteres especiais e espaço entre as letras.");
        }

        // Validação do email
        if (!emailValido) {
            editEmail.setError("Email deve conter '@'.");
        }

        // Validação da senha
        if (!senhaValida) {
            editSenha.setError("A senha deve conter:\n- Uma letra maiúscula\n- Duas letras minúsculas\n- Dois números\n- Pelo menos um caractere especial (@#$!).");
        }

        // Habilita ou desabilita o botão "Cadastrar"
        btnCadastrar.setEnabled(nomeValido && userValido && emailValido && senhaValida);

        // Retorna true se todos os campos forem válidos
        return nomeValido && userValido && emailValido && senhaValida;
    }

    // Função para abrir a próxima Activity após a validação bem-sucedida
    public void cadastrar() {
        Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
        // Exemplo de ação: abrir uma nova activity ou realizar uma ação
        Intent intent = new Intent(this, cadastro2.class);
        startActivity(intent);
    }
}
