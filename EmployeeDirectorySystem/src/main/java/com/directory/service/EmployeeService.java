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

    //getbyid method added
    Employee getEmpById(int id);

    //delete method added
    String deleteEmp(int id);

    //update method added
    Employee updateEmp(int id,Employee newEmp);
}
