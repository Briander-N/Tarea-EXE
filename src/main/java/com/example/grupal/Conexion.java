package com.example.grupal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String url =
            "jdbc:mysql://hayabusa.proxy.rlwy.net:18882/railway?useSSL=false&serverTimezone=UTC";

    private static final String user = "root";

    private static final String password = "pfcrGCopVupmOkbHlhpcYwXwiFuJznHt";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}