package com.ekrem.Falcon.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "workhours")
public class WorkHour {

    @Id
    Integer workid;
    Integer workhours;
    Date workdate;


    @ManyToOne
    @JoinColumn(name = "userid")
    User user;


    @ManyToOne
    @JoinColumn(name = "projectid")
    Project project;



}
