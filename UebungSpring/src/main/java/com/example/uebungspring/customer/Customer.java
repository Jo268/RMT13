package com.example.uebungspring.customer;

import com.example.uebungspring.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cID;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Project> projectList = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return String.format("Customer[name='%s', numberOfProjects=%d]",
                name,
                projectList.size()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cID, customer.cID)
                && Objects.equals(name, customer.name)
                && Objects.equals(projectList, customer.projectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cID, this.name, this.projectList);
    }

    public Long getCID() {
        return cID;
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setCID(Long id) {
        this.cID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public void assignProject(Project project) {
        this.projectList.add(project);
    }
}
