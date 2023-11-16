package com.ekrem.Falcon.dto;


import com.ekrem.Falcon.model.AssignProject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    String firstname;
    String lastname;
    String email;

    List<AssignProject>assignmentProjectList;

}
