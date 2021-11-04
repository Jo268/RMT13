package com.example.uebungspring.ticket;

import com.example.uebungspring.assignee.Assignee;
import com.example.uebungspring.customer.Customer;
import com.example.uebungspring.project.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findAllByAssigneeListContains(Assignee assignee);
}