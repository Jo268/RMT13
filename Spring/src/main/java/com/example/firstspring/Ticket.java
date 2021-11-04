package com.example.firstspring;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketId;
    private String name;
    private int hoursNeeded;
    private String project;

    protected Ticket() {
    }

    public Ticket(String name, int hoursNeeded, String project) {
        this.name = name;
        this.hoursNeeded = hoursNeeded;
        this.project = project;
    }

    @Override
    public String toString() {
        return String.format("Tickets[ticketId=%d, name='%s', deliveryDate=%d, project='%s']",
                ticketId,
                name,
                hoursNeeded,
                project
        );
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursNeeded() {
        return hoursNeeded;
    }

    public void setHoursNeeded(int hoursNeeded) {
        this.hoursNeeded = hoursNeeded;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
