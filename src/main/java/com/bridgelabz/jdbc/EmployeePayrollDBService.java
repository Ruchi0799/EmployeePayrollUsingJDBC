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

    public int updateEmployeeData(String name, double salary) {
     return this.updateEmployeeDataUsingStatement(name,salary);
    }

    public int updateEmployeeDataUsingStatement(String name, double salary) {
        String sql=String.format("update employee_payroll set salary=%2f where name='%s';",salary,name);
        try(Connection connection=this.getConnection()) {
            Statement statement=connection.createStatement();
            return statement.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 0;
    }


    public ResultSet retrieveAccordingToDate(String s) {

        String sql=String.format("select * from employee_payroll where start BETWEEN CAST('%s' AS DATE) AND DATE(NOW());",s);
        try(Connection connection=this.getConnection()) {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next())
            {
                System.out.println(
                        resultSet.getString(1)+" "+
                                resultSet.getString(2)+ " "+
                                resultSet.getString(3)+" "+
                                resultSet.getString(4)

                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet SumUsingGroupby(String value) {
        String sql=String.format("Select gender,sum(%s) from employee_payroll group by gender;",value);
        try(Connection connection=this.getConnection()) {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next())
            {
                System.out.println(
                        resultSet.getString(1)+" "+
                               resultSet.getString(2)

                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;

    }
}
