package com.example.uebungspring.project;

import com.example.uebungspring.ticket.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pID;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Ticket> ticketList = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return String.format("Project[name='%s', numberOfTickets=%d]",
                name,
                ticketList.size()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals(pID, project.pID) && Objects.equals(name, project.name) && Objects.equals(ticketList, project.ticketList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pID, name, ticketList);
    }

    public Long getPID() {
        return pID;
    }

    public void setPID(Long p_id) {
        this.pID = p_id;
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

    public void assignTicket(Ticket ticket) {
        this.ticketList.add(ticket);
    }
}
