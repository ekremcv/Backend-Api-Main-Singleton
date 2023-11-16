package com.ekrem.Falcon.controller;




import com.ekrem.Falcon.dto.WorkHoursDto;
import com.ekrem.Falcon.model.Project;
import com.ekrem.Falcon.model.WorkHour;
import com.ekrem.Falcon.service.WorkHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workhour")
public class WorkHoursController {
    @Autowired
    WorkHoursService workHoursService;

    @GetMapping("getAllWorkHours")
    public ResponseEntity<List<WorkHoursDto>> getAllWorkHours() {
        return workHoursService.getAllWorkHours();
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addWorkHour(@RequestBody WorkHour workHour ){
        return workHoursService.addWorkHour(workHour);
    }
    @DeleteMapping("delete/{workid}")
    public ResponseEntity<String> deleteWorkHour(@PathVariable Integer workid){
        return workHoursService.deleteWorkHour(workid);
    }
    @PutMapping("update/{workid}")
    public ResponseEntity<String>  updateWorkHour(@RequestBody WorkHour workHour, @PathVariable Integer workid){
        return workHoursService.updateWorkHour(workHour,workid);
    }
}
