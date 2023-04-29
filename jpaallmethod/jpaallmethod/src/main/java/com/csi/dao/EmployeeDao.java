package com.csi.dao;

import com.csi.model.Employee;
import com.csi.rapository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDao {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee signUp(Employee employee){
        return employeeRepository.save(employee);

    }
    public boolean signIn(String empEmailId, String empPassword){
        boolean falg = false;

        Employee employee=employeeRepository.findDataByEmpEmailIdAndEmpPassword(empEmailId,empPassword);

        if (employee!=null){
            falg=true;
        }
        return falg;
    }
    public Optional<Employee> getDataById(int empId){
        return employeeRepository.findById(empId);
    }
    public List<Employee>getAllData(){
      return   employeeRepository.findAll();
    }
    public List<Employee>getDataByFirstName(String empFirstName){
        return employeeRepository.findDataByEmpFirstName(empFirstName);
    }
    public List<Employee>getDataByNames(String empFirstName,String empLastName){
        return  employeeRepository.findDataByEmpFirstNameAndEmpLastName(empFirstName,empLastName);
    }
    public Employee getDataByContact(String empContact ){
        return employeeRepository.findDataByEmpContact(empContact);
    }
    public Employee getDataByEmail(String empEmailId){
        return employeeRepository.findDataByEmpEmailId(empEmailId);

    }
    public List<Employee> getDataByDob(String empDob){
List<Employee>employees=new ArrayList<>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");

        for (Employee employee:getAllData()){
            String dob=simpleDateFormat.format(employee.getEmpdob());
            if (dob.equals(empDob)){
                employees.add(employee);
            }
        }

  return employees;  }

    public List<Employee>saveBulkOfData(List<Employee>employees){
        return employeeRepository.saveAll(employees);
    }
    public Employee updateData(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteById(int empId){
       employeeRepository.deleteById(empId);
    }
    public void deleteAllData(){
        employeeRepository.deleteAll();
    }
}

