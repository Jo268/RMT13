package com.example.restservice.employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long employee_id;
    private String name;

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object otherObject){

        if (this == otherObject)
        return true;
        if(!(otherObject instanceof Employee))
            return false;
        Employee employee = (Employee) otherObject;
        return Objects.equals(this.employee_id, employee.employee_id)
                && Objects.equals(this.name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.employee_id, this.name);
    }

    @Override public String toString() {
        return "Employee{" + "id=" + this.employee_id + ", name='" + this.name + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long id) {
        this.employee_id = id;
    }

}
