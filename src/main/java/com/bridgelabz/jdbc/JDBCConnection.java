package com.bridgelabz.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private String url = "jdbc:mysql://localhost:3306/payroll_system?useSSL=false";
    private String username = "root";
    private String password = "ruchi";
    Connection con;

    public Connection getDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            System.out.println("Connecting to database"+url);
            con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection is successful!!"+con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
