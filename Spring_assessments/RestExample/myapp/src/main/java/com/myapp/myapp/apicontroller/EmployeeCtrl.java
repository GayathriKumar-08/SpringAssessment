package com.myapp.myapp.apicontroller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

//import javax.validation.Valid;

import com.myapp.myapp.entity.Employee;
import com.myapp.myapp.entity.InvalidEmployeeException;
import com.myapp.myapp.repository.Employeerepo;
import com.myapp.myapp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeCtrl {
    
    @Autowired
    private Employeerepo erepo;

    // @Autowired
    // private EmployeeService eService;

    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> submitData(@Valid @RequestBody Employee emp) {
        System.out.println("Insertion method!!!");
        System.out.println(emp);
       
                // Employee em = erepo.save(new Employee(emp.getEmpid(), emp.getEmpname(), emp.getEmpdes(),
                //         emp.getEmpage(), emp.getSalary()));

                     //   System.out.println(em.toString());

                 if (emp.getEmpid() == 0 || emp.getEmpname() == " ") {
                            throw new InvalidEmployeeException();

                } else {
                       erepo.save(emp);
                System.out.println("Employee details:" + emp);
                System.out.println("Successfully inserterd");
                return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
            }
    }
    
    @PutMapping(value = "/employee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id ,@RequestBody Employee emp){
        System.out.println(emp);
        erepo.save(emp);
       // eService.persitEmployee(emp);
       if(emp.getEmpid()==0)
       {
        return new ResponseEntity<Employee>(emp, HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    
    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> fetchAllStudent(){
       // System.out.println(id);
        return new ResponseEntity<List<Employee>>(erepo.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmp(@PathVariable int id){
       // System.out.println(id);
        return new ResponseEntity<List<Employee>>(erepo.findById(id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEmploye(@PathVariable int id){
      //eService.deleteEmpById(id);
      erepo.deleteById(id);
      System.out.println("deleted successfully....");
    }

}
