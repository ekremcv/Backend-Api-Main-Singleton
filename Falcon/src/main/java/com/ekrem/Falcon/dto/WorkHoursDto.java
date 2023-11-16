package com.ekrem.Falcon.dto;

import com.ekrem.Falcon.model.Project;
import com.ekrem.Falcon.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkHoursDto {
    Integer workhours;
    Date workdate;
    User user;
    Project project;





}
