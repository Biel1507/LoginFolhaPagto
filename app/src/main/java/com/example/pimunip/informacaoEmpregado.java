package com.example.pimunip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class informacaoEmpregado extends AppCompatActivity {

    Button btFolhaPagto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_empregado);

        btFolhaPagto = findViewById(R.id.btFolhaPagto);
    }

    public void FolhaPagto(View acessarFolha){
        Intent acessFolha = new Intent(informacaoEmpregado.this, folhaDePagamento.class);
        startActivity(acessFolha);

        finish();
    }
}