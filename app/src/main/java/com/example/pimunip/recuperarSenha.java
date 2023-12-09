package com.example.pimunip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class recuperarSenha extends AppCompatActivity {

    Button btCancelRecSenha;
    EditText novaSenha;
    EditText repetSenha;
    Button btContRecSenha;
    TextView lbRec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        novaSenha = findViewById(R.id.novaSenha);
        repetSenha = findViewById(R.id.repetSenha);
        btContRecSenha = findViewById(R.id.btContRecSenha);
        lbRec = findViewById(R.id.lbRec);

    }

    public void alterarSenha(View as) {

//        Bundle extras = getIntent().getExtras();
//
//        if (extras != null) {
//            String valorRecebido = extras.getString("chave_valor");
//
            String email = "lucas.rodrigues.almeida5@gmail.com";
//
            String senha = novaSenha.getText().toString();
            String rSenha = repetSenha.getText().toString();

            if (senha.equals(rSenha)) {
//                AtualizaSenha atualizaSenha = new AtualizaSenha();
//                atualizaSenha.atualizaSenhaUsuario(senha, email);

                lbRec.setText("Senha alterada com sucesso!");
                Intent confirmaRec = new Intent(recuperarSenha.this, MainActivity.class);
                startActivity(confirmaRec);

                finish();
            }else{
                lbRec.setText("Digite a mesma senha!");
            }
        }
    //}
        public void Cancela (View cancelar){

        Intent cancelarRec = new Intent(recuperarSenha.this, MainActivity.class);
        startActivity(cancelarRec);

        finish();
    }

}