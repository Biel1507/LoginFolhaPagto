package com.example.pimunip.dao;

import android.util.Log;

import com.example.pimunip.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizaSenha {

    public void atualizaSenhaUsuario(String email, String novaSenha){
        try {
            Connection conn = Conexao.conectar();

            if (conn != null){
                String sqlUp = "UPDATE usuario SET Senha = '"+novaSenha+"' WHERE Email = '"+email+"' ";
                PreparedStatement ps = conn.prepareStatement(sqlUp);

                // Configura os parâmetros da consulta
                ps.setString(1, novaSenha);
                ps.setString(2, email);

                // Executa a instrução de atualização
                int stringUpdate = ps.executeUpdate();

                if (stringUpdate > 0) {
                    Log.i("Update Senha", "Senha atualizada com sucesso");
                } else {
                    Log.i("Update Senha", "Nenhum registro encontrado para o email fornecido");
                }

                // Fecha a conexão
                conn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Log.e("Erro ao alterar a senha", e.getMessage());
        }
    }

}
