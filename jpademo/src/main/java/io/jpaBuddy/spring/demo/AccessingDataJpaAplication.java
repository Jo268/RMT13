package io.jpaBuddy.spring.demo;

import io.jpaBuddy.spring.demo.entities.Project;
import io.jpaBuddy.spring.demo.repositorys.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

public class AccessingDataJpaAplication {

    private static final Logger log =
            LoggerFactory.getLogger(AccessingDataJpaAplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaAplication.class);
    }

    @Bean
    public CommandLineRunner demo (ProjectRepository repository){
        return args -> {

            repository.save(new Project(1L, "Prodzilla", 2021-10-29, "manager", 1L, 2021-11-04));

            log.info("Customers found with findAll():");
            log.info("Projects found with findAll(): ");

        for (Project prodzilla : repository.findAll()) {
                log.info(prodzilla.toString());
                log.info("-------------- ------------------  -------------------- ---------------------");
            }
        };
    }
}
