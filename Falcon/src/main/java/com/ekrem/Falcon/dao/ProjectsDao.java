package com.ekrem.Falcon.dao;

import com.ekrem.Falcon.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsDao extends JpaRepository<Project,Integer> {
}
