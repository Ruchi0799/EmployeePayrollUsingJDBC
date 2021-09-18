package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.time.LocalDate;

public class EmployeePayrollData {
    public int id;
    public String name;
    public double salary;


    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
