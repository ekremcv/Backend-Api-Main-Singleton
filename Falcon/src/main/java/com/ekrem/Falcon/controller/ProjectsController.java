package com.ekrem.Falcon.controller;


import com.ekrem.Falcon.dto.ProjectDto;
import com.ekrem.Falcon.model.Project;

import com.ekrem.Falcon.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectsController {

    @Autowired
    ProjectsService projectsService;

    @GetMapping("getAllProjects")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
     return projectsService.getAllProjects();
    }


    @PostMapping("/add")
    public ResponseEntity<String>  addProject(@RequestBody Project project){
        return projectsService.addProject(project);
    }
    @DeleteMapping("delete/{projectid}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer projectid){
        return projectsService.deleteProject(projectid);
    }
    @PutMapping("update/{projectid}")
    public ResponseEntity<String>  updateProject(@RequestBody Project project, @PathVariable Integer projectid){
        return projectsService.updateProject(project,projectid);
    }


}
