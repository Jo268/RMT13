package com.example.restservice.project;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class ProjectController {

    private final ProjectRepository repository;

    ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

        @GetMapping("/customer/project/{id}")
        EntityModel<Project> one(@PathVariable Long id) {

        Project project = repository.findById(id) //
                .orElseThrow(() -> new ProjectNotFoundException(id));

        return EntityModel.of(project, //
                linkTo(methodOn(ProjectController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ProjectController.class).all()).withRel("project"));
    }

    @GetMapping("/customer/project")
    CollectionModel<EntityModel<Project>> all() {

        List<EntityModel<Project>> projects = repository.findAll().stream()
                .map(project -> EntityModel.of(project,
                        linkTo(methodOn(ProjectController.class).one(project.getProject_id())).withSelfRel(),
                        linkTo(methodOn(ProjectController.class).all()).withRel("project")))
                .collect(Collectors.toList());

        return CollectionModel.of(projects, linkTo(methodOn(ProjectController.class).all()).withSelfRel());
    }

    @PostMapping("/customer/project")
    @PreAuthorize("hasRole('ADMIN')")
    Project newProject(@RequestBody Project newProject) {
        return repository.save(newProject);
    }

    @PutMapping("/customer/project/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    Project replaceProject(@RequestBody Project newProject, @PathVariable Long id) {

        return repository.findById(id)
                .map(project -> {
                    project.setName(newProject.getName());
                    return repository.save(project);
                })
                .orElseGet(() -> {
                    newProject.setProject_id(id);
                    return repository.save(newProject);
                });
    }

    @DeleteMapping("/customer/project/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void deleteProject(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
