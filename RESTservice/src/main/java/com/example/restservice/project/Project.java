package com.example.restservice.project;

import com.example.restservice.ticket.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long project_id;
    private String name;
    @OneToMany
    List<Ticket> ticketList = new ArrayList<>();

    public Project() {}

    public Project(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", ticketList=" + ticketList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return project_id == project.project_id
                && Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id, name, ticketList);
    }

    public void assignTicket(Ticket ticket) {
        this.ticketList.add(ticket);
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

}
