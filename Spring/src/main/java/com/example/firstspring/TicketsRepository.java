package com.example.firstspring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketsRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByName(String name);

}