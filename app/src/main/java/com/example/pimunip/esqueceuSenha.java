package com.example.pimunip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class esqueceuSenha extends AppCompatActivity {

    Button btVoltarEsqSenha;
    Button btContEsqSenha;
    Button reenvCodEsqSenha;
    EditText codigoEsqSenha;
    TextView emailEsqSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);

        btVoltarEsqSenha = findViewById(R.id.btVoltarEsqSenha);
        btContEsqSenha = findViewById(R.id.btContEsqSenha);
        reenvCodEsqSenha = findViewById(R.id.reenvCodEsqSenha);
        codigoEsqSenha = findViewById(R.id.codigoEsqSenha);
        emailEsqSenha = findViewById(R.id.emailEsqSenha);

        // Obtenha o Intent que iniciou esta atividade
        Bundle extras = getIntent().getExtras();

        // Verifique se há extras e obtenha o valor da chave específica
        if (extras != null) {
            String valorRecebido = extras.getString("chave_valor");

            // Faça algo com o valor recebido, por exemplo, exiba-o em um TextView
            TextView emailEsqSenha = findViewById(R.id.emailEsqSenha);
            emailEsqSenha.setText(valorRecebido);
        }

        btVoltarEsqSenha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View voltar) {

                Intent voltarMain = new Intent(esqueceuSenha.this, MainActivity.class);
                startActivity(voltarMain);

                finish();
            }

        });
    }

    public void confirma(View confirmar){

        validaCodigo();
    }

    private void validaCodigo() {
        String codigo = codigoEsqSenha.getText().toString();

        if (codigo.equalsIgnoreCase("190377")){
            // Faça algo com o texto válido, por exemplo, mude a tela
            Intent intentRecSenha = new Intent(esqueceuSenha.this, recuperarSenha.class);
            startActivity(intentRecSenha);

            finish();

        }else if (codigo.equalsIgnoreCase("010233")){

            Intent intentRecSenha = new Intent(esqueceuSenha.this, recuperarSenha.class);

            finish();

            startActivity(intentRecSenha);

        }else if (codigo.equalsIgnoreCase("150270")){

            Intent intentRecSenha = new Intent(esqueceuSenha.this, recuperarSenha.class);
            startActivity(intentRecSenha);

            finish();

        }
    }

}

