package com.example.grupal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String url = "jdbc:mysql://localhost:3306/biblioteca_db";

    private static final String user = "root";

    private static final String password = "123456";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    };
}
