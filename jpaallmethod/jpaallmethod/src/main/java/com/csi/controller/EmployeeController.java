package com.csi.controller;

import com.csi.constants.EmployeeConstant;
import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;


    @PostMapping(EmployeeConstant.SIGNIUP)
    public ResponseEntity<Employee>signUp(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));
    }
    @GetMapping(EmployeeConstant.SIGNIIN)
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }
    @GetMapping(EmployeeConstant.GETDATABYID)
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return ResponseEntity.ok( employeeServiceImpl.getDataById(empId));
    }
    @GetMapping(EmployeeConstant.GETALLDATA)
    public ResponseEntity<List<Employee>>getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
    @GetMapping(EmployeeConstant.GETDATABYFIRSTNAME)
    public ResponseEntity<List<Employee>> getDataByFirstName( @PathVariable String empFirstName ){
        return ResponseEntity.ok(employeeServiceImpl.getDataByFirstName(empFirstName));
    }
    @GetMapping(EmployeeConstant.GETDATABYNAMEs)
    public ResponseEntity<List<Employee>>getDataByNames(@PathVariable String empFirstName,@PathVariable String empLastName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByNames(empFirstName,empLastName));
    }
    @GetMapping(EmployeeConstant.GETDATABYEMAIL)
    public ResponseEntity<Employee>getDataByEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmail(empEmailId));
    }
    @GetMapping(EmployeeConstant.GETDATABYCONTACT)
    public ResponseEntity<Employee>getDataByContact(@PathVariable String empContact){
        return ResponseEntity.ok(employeeServiceImpl.getDataByContact(empContact));
    }
    public ResponseEntity<List<Employee>> getDataByDob(@PathVariable String empDob){
        return ResponseEntity.ok(employeeServiceImpl.getDataByDob(empDob));
    }
    public ResponseEntity<Employee>updatedata(@RequestBody Employee employee,@PathVariable int empid){
        Employee  employee1=employeeServiceImpl.getDataById(empid).orElseThrow(()->new RecordNotFoundException("od dose not exist"));

        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpLastName(employee.getEmpLastName());
        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpdob(employee.getEmpdob());
        employee1.setEmpContact(employee.getEmpContact());

        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));

    }
    @GetMapping(EmployeeConstant.GETDATABYANYINPUT)
    public ResponseEntity<List<Employee>>getdatabyAnyInput(@PathVariable String input){
        List<Employee>employees=new ArrayList<>();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");

        for (Employee employee:employeeServiceImpl.getAllData()){
            String dob=simpleDateFormat.format(employee.getEmpdob());
            if (employee.getEmpFirstName().equals(input)
            ||employee.getEmpLastName().equals(input)
            ||employee.getEmpEmailId().equals(input)
            ||employee.getEmpContact().equals(input)
            ||employee.getEmpPassword().equals(input)
        ||String.valueOf(employee.getEmpSalary()).equals(input)
            ||String.valueOf(employee.getEmpId()).equals(input)
            ||employee.getEmpAddress().equals(input)
            ||dob.equals(input)){
                employees.add(employee);
            }
        }
   return ResponseEntity.ok(employees);
    }


    public ResponseEntity<List<Employee>>saveBulkOfData(@RequestBody List<Employee>employees){
        return ResponseEntity.ok(employeeServiceImpl.saveBulkOfData(employees));
    }

}
