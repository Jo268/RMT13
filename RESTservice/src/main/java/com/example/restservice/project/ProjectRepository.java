package com.example.restservice.project;

import com.example.restservice.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
   // List<Project> findByName(String name, Pageable pageable);
}
