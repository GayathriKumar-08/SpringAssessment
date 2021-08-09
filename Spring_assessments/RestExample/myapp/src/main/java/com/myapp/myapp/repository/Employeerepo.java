package com.myapp.myapp.repository;



import java.util.List;

import com.myapp.myapp.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface Employeerepo extends JpaRepository<Employee,Integer>{

    public List<Employee> findAll();

    public List<Employee> findById(int id);


    // public void deleteById(int id);
    public void deleteById(int id);

}
