package com.example.app_busmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.Connection;

public class TesteConexaoBD extends AppCompatActivity {
    TextView BancoTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_conexao_bd);

        Connection conn = conexaoBanco.conectar(TesteConexaoBD.this);
        BancoTeste = findViewById(R.id.BancoTeste);
    }
}