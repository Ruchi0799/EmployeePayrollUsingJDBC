package com.bridgelabz.jdbc;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class JDBCDemo {
    @Test
    public void getDB_Connection() {
        Connection dbConnection=new JDBCConnection().getDBConnection();
        System.out.println(dbConnection);
    }

    @Test
    public void givenEmployeePayrollInDb_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService=new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData=employeePayrollService.readEmployeePayrollData(IOService.DB_IO);
        Assert.assertEquals(4,employeePayrollData.size());

    }
}
