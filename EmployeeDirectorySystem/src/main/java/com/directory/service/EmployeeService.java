package com.directory.service;

import com.directory.entity.Employee;

import java.util.List;
//service interface

public interface EmployeeService
{
    //save method added
    String saveEmp(Employee employee);

    //getalldata method added
    List<Employee> getAllEmpData();

    Employee getEmpById(int id);

    String deleteEmp(int id);

    Employee updateEmp(int id,Employee newEmp);
}
