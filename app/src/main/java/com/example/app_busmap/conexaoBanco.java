package com.example.app_busmap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBanco {

    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://172.19.1.231;databaseName=bd_BUSMAP2;user=sa;password=@ITB123456;");
        } catch (SQLException e) {
            e.printStackTrace(); // Melhora o feedback
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
