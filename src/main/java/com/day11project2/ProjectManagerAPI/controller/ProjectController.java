package com.day11project2.ProjectManagerAPI.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.day11project2.ProjectManagerAPI.dto.ProjectRequestDto;
import com.day11project2.ProjectManagerAPI.dto.ProjectResponseDto;
import com.day11project2.ProjectManagerAPI.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
@Validated
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public List<ProjectResponseDto> getAllProjects() {
        return service.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponseDto getProjectById(
            @PathVariable Long id) {

        return service.getProjectById(id);
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDto>
    createProject(
            @Valid
            @RequestBody
            ProjectRequestDto dto) {

        return ResponseEntity
                .status(201)
                .body(service.saveProject(dto));
    }

    @PutMapping("/{id}")
    public ProjectResponseDto updateProject(
            @PathVariable Long id,
            @Valid
            @RequestBody
            ProjectRequestDto dto) {

        return service.updateProject(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(
            @PathVariable Long id) {

        service.deleteProject(id);

        return ResponseEntity.noContent().build();
    }
}