package io.jpaBuddy.spring.demo.entities;

import io.jpaBuddy.spring.demo.entities.Customer;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

    @Table(name = "project", indexes = {
            @Index(name = "idx_project_name", columnList = "name")
    })


    @Entity
    public class Project {
        @Id
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @PastOrPresent
        @Column(name = "start_date")
        private LocalDate startDate;

        @ManyToOne
        @JoinColumn(name = "manager_id")
        private Customer manager;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "project_id")
        private List<Ticket> tickets;

        @PastOrPresent
        @Column(name = "end_date")
        private LocalDate endDate;

        public Project() {
        }

        public Project(Long l, String prodzilla, int i, String manager, long l1, int i1) {
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

        public List<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(List<Ticket> tickets) {
            this.tickets = tickets;
        }

        public Customer getManager() {
            return manager;
        }

        public void setManager(Customer manager) {
            this.manager = manager;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
