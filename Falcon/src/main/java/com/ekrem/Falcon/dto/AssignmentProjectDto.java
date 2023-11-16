package com.ekrem.Falcon.dto;

import com.ekrem.Falcon.model.AssignProject;
import com.ekrem.Falcon.model.Project;
import com.ekrem.Falcon.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentProjectDto {

    Date assignmentdate;
    User user;
    Project project;
    List<AssignProject> assignProjectList;
}
