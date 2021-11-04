package com.example.restservice;

import com.example.restservice.customer.Customer;
import com.example.restservice.customer.CustomerRepository;
import com.example.restservice.employee.Employee;
import com.example.restservice.employee.EmployeeRepository;
import com.example.restservice.project.Project;
import com.example.restservice.project.ProjectRepository;
import com.example.restservice.ticket.Ticket;
import com.example.restservice.ticket.TicketRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private  static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            CustomerRepository customerRepository,
            ProjectRepository projectRepository,
            TicketRepository ticketRepository,
            EmployeeRepository employeeRepository
    ) {
        return args -> {
           Customer frank = customerRepository.save(new Customer("Frank"));
           Customer gandalf = customerRepository.save(new Customer("Gandalf"));
            Project prodzilla = projectRepository.save(new Project("Prodzilla"));
            Project ring = projectRepository.save(new Project("Der Ring"));
            frank.assignProject(prodzilla);
            customerRepository.save(frank);
            gandalf.assignProject(ring);
            customerRepository.save(gandalf);

            Ticket ticket1 = ticketRepository.save(new Ticket("Fancy backend stuff"));
            Ticket ticket2 = ticketRepository.save(new Ticket("Den Ladebalken der Farbgebung anpassen"));
            prodzilla.assignTicket(ticket1);
            prodzilla.assignTicket(ticket2);
            projectRepository.save(prodzilla);
            Ticket ticket3 = ticketRepository.save(new Ticket("Den einen Ring zerstören!"));
            Ticket ticket4 = ticketRepository.save(new Ticket("Den wahren König finden!"));
            ring.assignTicket(ticket3);
            ring.assignTicket(ticket4);
            projectRepository.save(ring);

            Employee frodo = employeeRepository.save(new Employee("Frodo Swaggins"));
            ticket3.assignEmployee(frodo);
            ticketRepository.save(ticket3);

            Employee dennis = employeeRepository.save(new Employee("Dennis"));
            ticket1.assignEmployee(dennis);
            ticketRepository.save(ticket1);
            Employee bilbo = employeeRepository.save(new Employee("Bilbo Swaggins"));
            Employee sam = employeeRepository.save(new Employee("Samwise Gumshee"));
            log.info("Preloading " + bilbo);
            log.info("Preloading " + sam);
        };
    }
}
