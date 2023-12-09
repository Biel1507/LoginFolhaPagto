package com.example.pimunip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class folhaDePagamento extends AppCompatActivity {

    TextView textSairPagto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folha_de_pagamento);

        textSairPagto = findViewById(R.id.textSairPagto);

        textSairPagto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sair = new Intent(folhaDePagamento.this, MainActivity.class);
                startActivity(sair);

                finish();
            }
        });

    }

    public void voltarPagto(View voltarpagto){
        Intent voltar = new Intent(folhaDePagamento.this, informacaoEmpregado.class);
        startActivity(voltar);

        finish();
    }

}