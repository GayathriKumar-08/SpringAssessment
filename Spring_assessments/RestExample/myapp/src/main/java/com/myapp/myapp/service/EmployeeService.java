package com.myapp.myapp.service;


import javax.transaction.Transactional;

import com.myapp.myapp.entity.Employee;

import org.springframework.stereotype.Service;
@Service
@Transactional
public interface EmployeeService {

    public Employee saveData(Employee emp1);

    public Employee updateById(int id, Employee emp1);
  
   //public void deleteEmpById(int id);

  // public Employee getEmpById(int id);
 
}
