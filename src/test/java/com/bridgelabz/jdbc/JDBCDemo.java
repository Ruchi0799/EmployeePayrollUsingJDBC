package com.bridgelabz.jdbc;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.time.LocalDate;
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

    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldMatch() {
        EmployeePayrollService employeePayrollService=new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData=employeePayrollService.readEmployeePayrollData(IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Terisa",4000000.00);
      // boolean result=employeePayrollService.checkEmployeePayrollInSyncWithDB("Terisa");
        //Assert.assertTrue(result);
    }

    @Test
    public void givenStartDate_RetriveAllTheEmployeesWhoJoined_InThatDateRange() throws SQLException {
        EmployeePayrollDBService employeePayrollDBService=new EmployeePayrollDBService();

        ResultSet resultSet=employeePayrollDBService.retrieveAccordingToDate("2018-01-01");
        
    }

    @Test
    public void abilityToFindSumOfSalary_ByGroupingAccordingToGender() throws SQLException {
        EmployeePayrollDBService employeePayrollDBService=new EmployeePayrollDBService();

        ResultSet resultSet=employeePayrollDBService.SumUsingGroupby("salary");

    }

    @Test
    public void abilityToAddNewEmployee() {
        EmployeePayrollDBService employeePayrollDBService=new EmployeePayrollDBService();
        employeePayrollDBService.addNewEmployee("Sagarika",'F',500000.00,"2021-09-09");
    }

    @Test
    public void abilityToAddEmployeeToPayroll() throws SQLException {
        EmployeePayrollDBService employeePayrollDBService=new EmployeePayrollDBService();
        employeePayrollDBService.addEmployeeToPayroll("Ruchi",'F',652000.00,"2021-08-02");
    }

    @Test
    public void abilityToAddEmployeeToPayrollUsingTransaction() throws SQLException {
        EmployeePayrollDBService employeePayrollDBService=new EmployeePayrollDBService();
        employeePayrollDBService.addEmployeeToPayroll("Prachi",'F',1000000.00,"2020-08-02");
    }

    @Test
    public void abilityToDisplayEmployeeOfEr() {
        EmployeePayrollDBService employeePayrollDBService=new EmployeePayrollDBService();
        employeePayrollDBService.printEntriesER();
    }
}
