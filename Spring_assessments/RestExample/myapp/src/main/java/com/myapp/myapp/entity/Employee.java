package com.myapp.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="empid")
    private int empid;
    
    @Column(name="empname")
    @NotNull(message = "emp name is mandatory")
    @Size(min=4, max=10, message = "name must be min of 4 and max of 10")
    private String empname;

    @Column(name="empdesignation")
    @NotNull(message = "emp designation is mandatory")
    @Size(min=4, max=10, message = "designation must be min of 4 and max of 10")
    private String empdes;

    @Column(name="empage")
    @Positive(message = "emp age cannot be zero or -ve")
    private int empage;

    @Column(name="salary")
    @Positive(message = "emp salary cannot be zero or -ve")
    private int salary;

    // @Transient
    // private String sex;
     
    // @Temporal(TemporalType.DATE)
    // private Date joinDate;
     
    public Employee() {
    }

    public Employee(int empid,
            @NotNull(message = "emp name is mandatory") @Size(min = 4, max = 10, message = "name must be min of 4 and max of 10") String empname,
            @NotNull(message = "emp designation is mandatory") @Size(min = 4, max = 10, message = "designation must be min of 4 and max of 10") String empdes,
            @Positive(message = "emp age cannot be zero or -ve") int empage,
            @Positive(message = "emp salary cannot be zero or -ve") int salary) {
        this.empid = empid;
        this.empname = empname;
        this.empdes = empdes;
        this.empage = empage;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpdes() {
        return empdes;
    }

    public void setEmpdes(String empdes) {
        this.empdes = empdes;
    }

    public int getEmpage() {
        return empage;
    }

    public void setEmpage(int empage) {
        this.empage = empage;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [empage=" + empage + ", empdes=" + empdes + ", empid=" + empid + ", empname=" + empname
                + ", salary=" + salary + "]";
    }

   
}
