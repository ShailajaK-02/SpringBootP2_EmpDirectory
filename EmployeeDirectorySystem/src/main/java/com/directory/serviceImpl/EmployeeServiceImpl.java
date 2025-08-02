package com.directory.serviceImpl;

import com.directory.entity.Employee;
import com.directory.repository.EmployeeRepository;
import com.directory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    //inject repository in service impl
    @Autowired
    private EmployeeRepository repository;

    @Override
    public String saveEmp(Employee employee) {
        Employee emp = repository.save(employee);
        return "Employee added successfully";
    }

    @Override
    public List<Employee> getAllEmpData() {
       List<Employee> employeeList = repository.findAll();
       return employeeList;
    }

    @Override
    public Employee getEmpById(int id) {
       Employee empbyId=  repository.findById(id).orElseThrow(() ->new NullPointerException("Employee withthis id is not found" + id));
       return empbyId;
    }
}
