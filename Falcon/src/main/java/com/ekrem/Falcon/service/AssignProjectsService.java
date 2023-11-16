package com.ekrem.Falcon.service;


import com.ekrem.Falcon.dao.AssignProjectsDao;
import com.ekrem.Falcon.dto.AssignmentProjectDto;
import com.ekrem.Falcon.model.AssignProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignProjectsService {

    @Autowired
    AssignProjectsDao assignProjectsDao;

    public ResponseEntity<List<AssignmentProjectDto>> getAllAssigns() {
        try {
            return new ResponseEntity<>(assignProjectsDao.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addAssigns(AssignProject assignProject) {

        assignProjectsDao.save(assignProject);

        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteAssigns(Integer assignmentid) {

        try {
            assignProjectsDao.deleteById(assignmentid);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<>("Assign Project not deleted.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateAssigns(AssignProject assignProject, Integer assignmentid) {
        assignProjectsDao.findById(assignmentid);
        assignProjectsDao.save(assignProject);
        return new ResponseEntity<>("AssignProject Table Updated", HttpStatus.OK);
    }

    private AssignmentProjectDto convertEntityToDto(AssignProject assignProject) {
        AssignmentProjectDto assignmentProjectDto = new AssignmentProjectDto();
        assignmentProjectDto.setAssignmentdate(assignProject.getAssignmentdate());
        assignmentProjectDto.setUser(assignProject.getUser());
        assignmentProjectDto.setProject(assignProject.getProject());
        return assignmentProjectDto;

    }
}
