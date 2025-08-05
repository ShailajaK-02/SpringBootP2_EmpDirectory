package com.directory.controller;

import com.directory.entity.Employee;
import com.directory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeData")
public class EmployeeController {

    //inject emp Service in controller
    @Autowired
    private EmployeeService employeeService;

    //Add emp data
    @PostMapping("/addEmp")
    public ResponseEntity<String> addEmp(@RequestBody Employee employee){
        System.err.println(employee);
        employeeService.saveEmp(employee);
        return new ResponseEntity<>("Data saved", HttpStatus.CREATED);
    }

    //get all data
    @GetMapping("/getAllEmp")
    public ResponseEntity<List<Employee>> getAllEmp(){
        List<Employee> employeeList = employeeService.getAllEmpData();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    //get emp by id
    @GetMapping("/getEmpById/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id){
        Employee empById = employeeService.getEmpById(id);
        return new ResponseEntity<>(empById,HttpStatus.OK);
    }

    //delete api
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        employeeService.deleteEmp(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable("id") int id, @RequestBody Employee employee){
      Employee updatedEmp  = employeeService.updateEmp(id,employee);
      return new ResponseEntity<>(updatedEmp,HttpStatus.OK);
    }
}
