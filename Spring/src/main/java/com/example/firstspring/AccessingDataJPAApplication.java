package com.example.firstspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class AccessingDataJPAApplication {

    private static final Logger log =
            LoggerFactory.getLogger(AccessingDataJPAApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJPAApplication.class);
    }

    @Order(1)
    @Bean
    public CommandLineRunner demo(CustomerRepository repository, TicketsRepository trepository) {
        return args -> {
            //  erstellen von demo Customer
            Customer dennis = repository.save(new Customer("Dennis", "Dierkes", "Prodzilla"));
            repository.save(new Customer("Astrid", "Lindemar", "CTrace"));
            repository.save(new Customer("Michelle", "Anfang", "IKEA"));
            repository.save(new Customer("Wolfgang", "Gothard", "Prodzilla"));
            repository.save(new Customer("Alfred", "HitchHiker", "IKEA"));

            Ticket ticket1 = trepository.save((new Ticket("ticket1", 5, "Prodzilla")));
            dennis.assignTicket(ticket1);
            repository.save(dennis);

            // gib alle aus mit eingebundener findAll methode
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
                log.info("-------------- ------------------  -------------------- ---------------------");
            }
            log.info("");

            // suche nach ID mit eigener Methode
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // suche nach last name
            log.info("Customer found with findByLastName('Anfang'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Anfang").forEach(anfang -> {
                log.info(anfang.toString());
            });
            for (Customer gothart : repository.findByLastName("Gothart")) {
                log.info(gothart.toString());
            }
            log.info("");
            // suche nach project
            log.info(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
            log.info("Customer found with findByProject('Prodzilla'):");
            repository.findByProject("Prodzilla").forEach(prodzilla -> {
                log.info(prodzilla.toString());
            });
            log.info(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
            log.info("");
        };
    }


}


