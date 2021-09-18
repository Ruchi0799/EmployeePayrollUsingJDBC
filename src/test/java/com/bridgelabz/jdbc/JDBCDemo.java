package com.bridgelabz.jdbc;
import org.junit.Test;

import java.sql.*;

public class JDBCDemo {
    @Test
    public void getDB_Connection() {
        Connection dbConnection=new JDBCConnection().getDBConnection();
        System.out.println(dbConnection);
    }

}
