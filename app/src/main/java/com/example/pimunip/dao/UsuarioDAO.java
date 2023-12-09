package com.example.pimunip.dao;

import android.util.Log;

import com.example.pimunip.conexao.Conexao;
import com.example.pimunip.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    public Usuario selecionaUsuario(String email, String senha){
        try {
            Connection conn = Conexao.conectar();

            if (conn != null){
                String sql = "select * from usuario where Email = '"+email+"' and Senha = '"+senha+"'";
                Statement st = null;

                st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    Usuario usu = new Usuario();
                    usu.setCodigo(rs.getInt(1));
                    usu.setEmail(rs.getString(2));
                    usu.setSenha(rs.getString(3));

                    conn.close();
                    return usu;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.e("Erro login", e.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.e("Erro login", throwables.getMessage());
        }

        return null;
    }
}
