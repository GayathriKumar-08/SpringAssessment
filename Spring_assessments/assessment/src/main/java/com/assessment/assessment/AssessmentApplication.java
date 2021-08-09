package com.assessment.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.assessment.assessment.Config.EmployeeConfig;


@SpringBootApplication
public class AssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
		
		ApplicationContext ctx =new AnnotationConfigApplicationContext(EmployeeConfig.class);
	
		EmployeeConfig emp = ctx.getBean(EmployeeConfig.class);
	    emp.employee().setEmpid(101);
		emp.employee().setEmpname("gayu");
		emp.employee().setMessage("belong to IT department");

		System.out.println(emp.employee().getEmpid());
		System.out.println(emp.employee().getEmpname());
		System.out.println(emp.employee().getMessage());

	}

}
