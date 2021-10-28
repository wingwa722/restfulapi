package com.afs.restfulapi.Exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(){
        super("Employee not found!");
    }
}
