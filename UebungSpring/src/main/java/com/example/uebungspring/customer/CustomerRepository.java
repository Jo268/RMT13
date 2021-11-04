package com.example.uebungspring.customer;

import com.example.uebungspring.project.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findOneByName(String name);

    List<Customer> findAllByProjectListContains(Project project);

    // @Query(value = "SELECT * FROM Customer WHERE project = prodzilla", nativeQuery = true)
    //  List<Customer> findCustomerForProjectProdzilla();
}
