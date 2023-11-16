package com.ekrem.Falcon.dao;

import com.ekrem.Falcon.model.AssignProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignProjectsDao extends JpaRepository<AssignProject,Integer> {
}
