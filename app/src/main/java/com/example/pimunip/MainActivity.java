package com.example.pimunip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pimunip.dao.UsuarioDAO;
import com.example.pimunip.model.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText emailLogin, senhaLogin;
    TextView esqueceuLogin;
    Button btLogar;
    TextView lbResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailLogin = findViewById(R.id.emailLogin);
        senhaLogin = findViewById(R.id.senhaLogin);
        btLogar = findViewById(R.id.btLogar);
        lbResultado = findViewById(R.id.lbResultado);

        TextView esqueceuLogin = findViewById(R.id.esqueceuLogin);

        esqueceuLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // O código a ser executado quando o TextView (botão) for clicado
                validarEditText();

            }

        });
    }

    private void validarEditText() {
        String email2 = emailLogin.getText().toString().trim();

        if (TextUtils.isEmpty(email2)) {
        } else {
            // Faça algo com o texto válido, por exemplo, mude a tela
            Intent intentSenha = new Intent(MainActivity.this, esqueceuSenha.class);

            intentSenha.putExtra("chave_valor", email2);
            startActivity(intentSenha);

            finish();

        }
    }


    public void login(View v) {
            String email = emailLogin.getText().toString();
            String senha = senhaLogin.getText().toString();

            Usuario usu = new UsuarioDAO().selecionaUsuario(email, senha);  //conexão com o BD
                if (usu != null) {
//            if (email.equals("lucas.rodrigues.almeida5@gmail.com") && senha.equals("Pay@1234")){

                lbResultado.setText("Logado com sucesso!");
                Intent intent = new Intent(MainActivity.this, informacaoEmpregado.class);
                startActivity(intent);

                finish();

            } else {

                lbResultado.setText("Email e/ou Senha inválido!");
                limpar();

            }

    }

//            if(email.equalsIgnoreCase("gabrielsousa@gmail.com")){
//                if(senha.equalsIgnoreCase("12345")){
//                    lbResultado.setText("Logado com sucesso!");
//                    Intent intent = new Intent(MainActivity.this, folhaDePagamento.class);
//                    startActivity(intent);
//
//                    finish();
//                }else{
//                    lbResultado.setText("E-mail ou senha inválido(a)!");
//                    limpar();
//                }
//
//            } else {
//                lbResultado.setText("E-mail ou senha inválido(a)!");
//                limpar();
//            }


//        public void onClick(View vi){
//            String esqueceu = esqueceuLogin.getText().toString();
//
//            Esquece esq = new SendMailTask().doInBackground(esqueceu);
//            if (esqueceuLogin != null){
//                Intent intentSenha = new Intent(MainActivity.this, esqueceuSenha.class);
//                startActivity(intentSenha);
//
//                finish();
//            }
//        }

    private void limpar(){
//        emailLogin.setText("");
        senhaLogin.setText("");
        emailLogin.requestFocus();
    }
}