package com.bridgelabz.jdbc;

import java.util.List;

public class EmployeePayrollService {




    public enum I0Service {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    public List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {}

    public EmployeePayrollService (List<EmployeePayrollData>
                                           employeePayrollList) {
        this.employeePayrollList=employeePayrollList;

    }

    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
       // return null;
//        if (ioService.equals(IOService.FILE_IO))
//            this.employeePayrollList=new EmployeePayrollFileIOService().readData();
        if(ioService.equals(IOService.DB_IO))
            this.employeePayrollList=new EmployeePayrollDBService().readData();
        return this.employeePayrollList;
    }

    public void updateEmployeeSalary(String name, double salary) {
        int result=new EmployeePayrollDBService().updateEmployeeData(name,salary);
        if(result==0) return;
        EmployeePayrollData employeePayrollData=this.getEmployeePayrollData(name);
        if(employeePayrollData!=null) employeePayrollData.salary=salary;


    }

//    public boolean checkEmployeePayrollInSyncWithDB(String terisa) {
//        List<EmployeePayrollData> employeePayrollDataList=new
//    }

    private EmployeePayrollData getEmployeePayrollData(String name) {
        return this.employeePayrollList.stream().filter(employeePayrollData -> employeePayrollData.name.equals(name)).findFirst().orElse(null);

    }


}
