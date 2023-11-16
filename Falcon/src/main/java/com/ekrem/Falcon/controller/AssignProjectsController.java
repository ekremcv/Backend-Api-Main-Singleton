package com.ekrem.Falcon.controller;


import com.ekrem.Falcon.dto.AssignmentProjectDto;
import com.ekrem.Falcon.model.AssignProject;
import com.ekrem.Falcon.service.AssignProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assigns")
public class AssignProjectsController {

    @Autowired
    AssignProjectsService assignProjectsService;

    @GetMapping("getAllAssigns")
    public ResponseEntity<List<AssignmentProjectDto>> getAllAssigns(){
        return assignProjectsService.getAllAssigns();
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addAssigns(@RequestBody AssignProject assignProject){
        return assignProjectsService.addAssigns(assignProject);
    }
    @DeleteMapping("delete/{assignmentid}")
    public ResponseEntity<String> deleteAssigns(@PathVariable Integer assignmentid){
        return assignProjectsService.deleteAssigns(assignmentid);
    }

    @PutMapping("update/{assignmentid}")
    public ResponseEntity<String>  updateAssigns(@RequestBody AssignProject assignProject, @PathVariable Integer assignmentid){
        return assignProjectsService.updateAssigns(assignProject,assignmentid);
    }

}
