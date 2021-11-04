package com.example.restservice.ticket;

class TicketNotFoundException extends RuntimeException {

    TicketNotFoundException(Long id) {
        super("Could not find ticket " + id);
    }
}
