package com.example.restservice.ticket;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class TicketController {

    private final TicketRepository repository;

    TicketController(TicketRepository repository){this.repository = repository;}


        @GetMapping("/customer/project/ticket/{id}")
        EntityModel<Ticket> one(@PathVariable Long id) {

        Ticket ticket = repository.findById(id) //
                .orElseThrow(() -> new TicketNotFoundException(id));

        return EntityModel.of(ticket, //
                linkTo(methodOn(TicketController.class).one(id)).withSelfRel(),
                linkTo(methodOn(TicketController.class).all()).withRel("ticket"));
    }

    @GetMapping("/customer/project/ticket")
    CollectionModel<EntityModel<Ticket>> all() {

        List<EntityModel<Ticket>> tickets = repository.findAll().stream()
                .map(ticket -> EntityModel.of(ticket,
                        linkTo(methodOn(TicketController.class).one(ticket.getTicket_id())).withSelfRel(),
                        linkTo(methodOn(TicketController.class).all()).withRel("ticket")))
                .collect(Collectors.toList());

        return CollectionModel.of(tickets, linkTo(methodOn(TicketController.class).all()).withSelfRel());
    }

    @PostMapping("/customer/project/ticket")
    @PreAuthorize("hasRole('ADMIN')")
    Ticket newTicket(@RequestBody Ticket newTicket){return repository.save(newTicket);}

    @PutMapping("/customer/project/ticket")
    @PreAuthorize("hasRole('ADMIN')")
    Ticket replaceTicket(@RequestBody Ticket newTicket, @PathVariable Long id){
                return repository.findById(id)
                .map(ticket -> {
                    ticket.setTasks(newTicket.getTasks());
                    return repository.save(ticket);
                })
                .orElseGet(() -> {
                    newTicket.setTicket_id(id);
                    return repository.save(newTicket);
                });

    }

    @DeleteMapping("/customer/project/ticket/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void deleteTicket(@PathVariable Long id) {repository.deleteById(id);}
}
