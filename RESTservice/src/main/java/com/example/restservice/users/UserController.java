package com.example.restservice.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
class UserController{
    @Autowired
    InMemoryUserDetailsManager manager;

    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    EntityModel<UserDetails> createUser() {
        UserDetails user = User.withUsername("jo").password("jo").roles("ADMIN").build();
        manager.createUser(user);
        return EntityModel.of(user);
    }

    @DeleteMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    manager.deleteUser("Jo");
    // void deleteUser(String username) {this.user.remove(username.toLowerCase());

}
