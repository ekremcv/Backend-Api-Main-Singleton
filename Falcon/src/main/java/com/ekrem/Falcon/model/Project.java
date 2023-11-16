package com.ekrem.Falcon.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "projects")
public class Project {


    @Id
    Integer projectid;
    String projectname;


    @ManyToOne
    @JoinColumn(name = "responsible_userid")
    User user;






}
