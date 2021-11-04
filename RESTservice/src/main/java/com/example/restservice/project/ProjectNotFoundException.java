package com.example.restservice.project;

class ProjectNotFoundException extends RuntimeException {

    ProjectNotFoundException(Long id) {
        super("Could not find project " + id);
    }
}
