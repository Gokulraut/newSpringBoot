package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

@Autowired
    EmployeeDao employeeDaoImpl;


    public Employee signUp(Employee employee){
        return employeeDaoImpl.signUp(employee);

    }
    public boolean signIn(String empEmailId, String empPassword){
        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }
    public Optional<Employee> getDataById(int empId){
        return employeeDaoImpl.getDataById(empId);
    }
    public List<Employee> getAllData(){
        return   employeeDaoImpl.getAllData();
    }
    public List<Employee>getDataByFirstName(String empFirstName){
        return employeeDaoImpl.getDataByFirstName(empFirstName);
    }
    public List<Employee>getDataByNames(String empFirstName,String empLastName){
        return  employeeDaoImpl.getDataByNames(empFirstName,empLastName);
    }
    public Employee getDataByContact(String empContact ){
        return employeeDaoImpl.getDataByContact(empContact);
    }
    public Employee getDataByEmail(String empEmailId){
        return employeeDaoImpl.getDataByEmail(empEmailId);

    }
    public List<Employee> getDataByDob(String empDob){



        return employeeDaoImpl.getDataByDob(empDob);  }

    public List<Employee>saveBulkOfData(List<Employee>employees){
        return employeeDaoImpl.saveBulkOfData(employees);
    }
    public Employee updateData(Employee employee){
        return employeeDaoImpl.updateData(employee);
    }
    public void deleteById(int empId){
        employeeDaoImpl.deleteById(empId);
    }
    public void deleteAllData(){
        employeeDaoImpl.deleteAllData();
    }
}
