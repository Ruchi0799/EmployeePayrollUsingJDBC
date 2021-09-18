package com.bridgelabz.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
    private String url = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
    private String username = "root";
    private String password = "ruchi";
    Connection con;
    public List<EmployeePayrollData> readData() {
        String sql="SELECT * FROM employee_payroll;";
        List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
        try {
            Connection connection=this.getConnection();
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(sql);
            while (result.next()){
                int id=result.getInt("id");
                String name=result.getString("name");
                double salary=result.getDouble("salary");
                LocalDate startDate=result.getDate("start").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id,name,salary,startDate));
            }
            connection.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return employeePayrollList;
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            System.out.println("Connecting to database"+url);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection is successful!!"+con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
