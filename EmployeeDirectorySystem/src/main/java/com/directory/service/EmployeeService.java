package com.directory.service;

import com.directory.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    String saveEmp(Employee employee);

    List<Employee> getAllEmpData();

    Employee getEmpById(int id);
}
