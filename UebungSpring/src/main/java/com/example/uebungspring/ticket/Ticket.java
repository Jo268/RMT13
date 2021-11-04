package com.example.uebungspring.ticket;

import com.example.uebungspring.assignee.Assignee;
import com.example.uebungspring.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tID;
    private String tasks;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pID")
    private Project project;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Assignee> assigneeList = new ArrayList<>();

    public Ticket(String tasks) {
        this.tasks = tasks;
    }

    public Ticket() {
    }

    @Override
    public String toString() {
        return String.format("Ticket[tasks='%s', assignees=%d]",
                tasks,
                assigneeList.size()
        );
    }

    public Long getTID() {
        return tID;
    }

    public void setTID(Long ticket_id) {
        this.tID = ticket_id;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public List<Assignee> getAssigneeList() {
        return assigneeList;
    }

    public void setAssigneeList(List<Assignee> assigneeList) {
        this.assigneeList = assigneeList;
    }

    public void assignAssignee(Assignee assignee) {
        this.assigneeList.add(assignee);
    }
}
