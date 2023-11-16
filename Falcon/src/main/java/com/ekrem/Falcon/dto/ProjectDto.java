package com.ekrem.Falcon.dto;

import com.ekrem.Falcon.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDto {
    Integer projectid;
    String projectname;
    User user;
}
