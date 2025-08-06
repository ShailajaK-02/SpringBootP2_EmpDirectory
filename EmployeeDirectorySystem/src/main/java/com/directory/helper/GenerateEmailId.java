package com.directory.helper;

import com.directory.entity.Employee;

public class GenerateEmailId {

    public static String generateEmail(Employee employee){

        //to generate email id
        String name = employee.getName();

        int digit = employee.getYearOfBirth() % 100;

        String emailId = name + digit + "@gmail.com";

        return emailId;
    }
}
