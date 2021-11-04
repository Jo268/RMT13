package com.example.uebungspring.assignee;

import javax.persistence.*;

@Entity
@Table(name = "Assignee")
public class Assignee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aID;
    private String name;

    public Assignee() {
    }

    public Assignee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Assignee[name='%s']",
                name
        );
    }

    public Long getAID() {
        return aID;
    }

    public void setAID(Long id) {
        this.aID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
