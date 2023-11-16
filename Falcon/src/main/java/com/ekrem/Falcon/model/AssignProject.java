package com.ekrem.Falcon.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "assignmentprojects")
public class AssignProject {


    @Id
    Integer assignmentid;
    Date  assignmentdate;

    @ManyToOne
    @JoinColumn(name = "userid")
    User user;

    @ManyToOne
    @JoinColumn(name = "projectid")
    Project project;




}
