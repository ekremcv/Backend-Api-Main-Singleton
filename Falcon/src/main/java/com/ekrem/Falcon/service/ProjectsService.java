package com.ekrem.Falcon.service;


import com.ekrem.Falcon.dao.ProjectsDao;

import com.ekrem.Falcon.dto.ProjectDto;
import com.ekrem.Falcon.dto.UserDto;
import com.ekrem.Falcon.model.Project;

import com.ekrem.Falcon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectsService {

    @Autowired
    ProjectsDao projectsDao;



    public ResponseEntity<List<ProjectDto>> getAllProjects() {

        try {
            return new ResponseEntity<>(projectsDao.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addProject(Project project) {
        projectsDao.save(project);
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteProject(Integer projectid) {

        try {
            projectsDao.deleteById(projectid);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<>("Project not deleted.", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> updateProject(Project project, Integer projectid) {
        projectsDao.findById(projectid);
        projectsDao.save(project);

        return new ResponseEntity<>("Projects updated", HttpStatus.OK);

    }

    private ProjectDto convertEntityToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectid(project.getProjectid());
        projectDto.setProjectname(project.getProjectname());
        projectDto.setUser(project.getUser());

        return projectDto;
    }
}
