package com.day11project2.ProjectManagerAPI.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day11project2.ProjectManagerAPI.dto.ProjectRequestDto;
import com.day11project2.ProjectManagerAPI.dto.ProjectResponseDto;
import com.day11project2.ProjectManagerAPI.entity.Project;
import com.day11project2.ProjectManagerAPI.exception.ResourceNotFoundException;
import com.day11project2.ProjectManagerAPI.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<ProjectResponseDto> getAllProjects() {

        return repository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ProjectResponseDto getProjectById(Long id) {

        Project project = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found"));

        return convertToDto(project);
    }

    public ProjectResponseDto saveProject(
            ProjectRequestDto dto) {

        Project project = new Project();

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());

        return convertToDto(
                repository.save(project));
    }

    public ProjectResponseDto updateProject(
            Long id,
            ProjectRequestDto dto) {

        Project project = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found"));

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());

        return convertToDto(
                repository.save(project));
    }

    public void deleteProject(Long id) {

        Project project = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found"));

        repository.delete(project);
    }

    private ProjectResponseDto convertToDto(
            Project project) {

        ProjectResponseDto dto =
                new ProjectResponseDto();

        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());

        return dto;
    }
}