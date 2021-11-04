package io.jpaBuddy.spring.demo.repositorys;

import io.jpaBuddy.spring.demo.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByName(String name);

    @Query("select p from Project p where p.endDate is null")
    List<Project> findByEndDate ();
}