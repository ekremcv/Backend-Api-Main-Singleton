package com.ekrem.Falcon.service;


import com.ekrem.Falcon.dao.WorkHoursDao;
import com.ekrem.Falcon.dto.WorkHoursDto;
import com.ekrem.Falcon.model.WorkHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkHoursService {

    @Autowired
    WorkHoursDao workHoursDao;

    public ResponseEntity<List<WorkHoursDto>> getAllWorkHours() {

        try{
            return new ResponseEntity<>(workHoursDao.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList()), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addWorkHour(WorkHour workHour) {

        workHoursDao.save(workHour);
        return new ResponseEntity<>("Successful",HttpStatus.CREATED);

    }

    public ResponseEntity<String> deleteWorkHour(Integer workid) {
        try {
            workHoursDao.deleteById(workid);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>("WorkHour not deleted.",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateWorkHour(WorkHour workHour, Integer workid) {
        workHoursDao.findById(workid);
        workHoursDao.save(workHour);
        return new ResponseEntity<>("WorkHour Updated",HttpStatus.OK);
    }


    private WorkHoursDto convertEntityToDto(WorkHour workHour) {
        WorkHoursDto workHoursDto=new WorkHoursDto();
        workHoursDto.setWorkdate(workHour.getWorkdate());
        workHoursDto.setWorkhours(workHour.getWorkhours());
        workHoursDto.setUser(workHour.getUser());
        workHoursDto.setProject(workHour.getProject());
        return workHoursDto;
    }
}
