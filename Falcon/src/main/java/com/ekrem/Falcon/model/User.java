package com.ekrem.Falcon.model;

import com.ekrem.Falcon.dto.AssignmentProjectDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "userid")
    private
    Integer userid;
    @Column(name = "firstname")
    private
    String firstname;
    @Column(name = "lastname")
    private
    String lastname;
    @Column(name = "email")
    private
    String email;

    @OneToMany
    @JoinColumn(name="userid")
    @JsonBackReference
    List<AssignProject> assignProjectList;


}
