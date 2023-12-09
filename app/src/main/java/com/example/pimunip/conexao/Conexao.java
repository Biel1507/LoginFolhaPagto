package com.example.pimunip.conexao;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        StrictMode.ThreadPolicy politica;

        politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);

        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        String ip = "192.168.1.40:1433";
        String db = "SGM";
        String user = "pimUnip";
        String password = "1507";

        String connString = "jdbc:jtds:sqlserver://"+ip+";databaseName="+db+";user="+user+";password="+password+";";
        conn = DriverManager.getConnection(connString);

        return conn;
    }
}
