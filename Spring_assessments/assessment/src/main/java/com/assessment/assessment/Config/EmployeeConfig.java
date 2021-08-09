package com.assessment.assessment.Config;

import com.assessment.assessment.Model.Employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean 
   public Employee employee(){
      return new Employee();
   }
    
}
