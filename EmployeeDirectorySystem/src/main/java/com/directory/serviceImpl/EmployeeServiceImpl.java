package com.directory.serviceImpl;

import com.directory.entity.Employee;
import com.directory.helper.GenerateEmailId;
import com.directory.repository.EmployeeRepository;
import com.directory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//service implementation

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    //inject repository in service impl
    @Autowired
    private EmployeeRepository repository;

    //save emp implemented
    @Override
    public String saveEmp(Employee employee) {
        //call from here
        String emailId = GenerateEmailId.generateEmail(employee);

        //save emailId in database
        employee.setEmailId(emailId);

        Employee emp = repository.save(employee);
        return "Hello "+ employee.getName() + " Your email id is : " + employee.getEmailId() ;
    }

    //get all data implemented
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

    @Override
    public String deleteEmp(int id) {
        repository.deleteById(id);
        return "Employee deleted";
    }

    @Override
    public Employee updateEmp(int id, Employee newEmp) {
        Employee employee = repository.findById(id).orElseThrow(()->new NullPointerException("Data not found"+id));

        employee.setName(newEmp.getName());
        employee.setSalary(newEmp.getSalary());

        Employee updatedEmp = repository.save(employee);
        return updatedEmp;
    }
}
