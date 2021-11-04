package com.example.restservice.customer;

import com.example.restservice.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Project> projectList = new ArrayList<>();

    //Konstruktoren
    public Customer(String name){this.name = name;}

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", projectList=" + projectList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return customer_id == customer.customer_id
                && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, name, projectList);
    }

    public void assignProject(Project project) {
        this.projectList.add(project);
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

}
