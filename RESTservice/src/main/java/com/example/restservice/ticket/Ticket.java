package com.example.restservice.ticket;

import com.example.restservice.employee.Employee;
import com.example.restservice.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticket_id;
    private String tasks;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Employee> employeeList = new ArrayList<>();

    public Ticket(String tasks) {
        this.tasks = tasks;
    }

    public Ticket() {
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tasks='" + tasks + '\'' +
                ", EmployeeList=" + employeeList.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return ticket_id == ticket.ticket_id
                && Objects.equals(tasks, ticket.tasks)
                && Objects.equals(project, ticket.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket_id, tasks, project, employeeList);
    }

    public void assignEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {this.employeeList = employeeList;}
}
