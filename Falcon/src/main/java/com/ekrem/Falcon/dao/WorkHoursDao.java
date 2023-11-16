package com.ekrem.Falcon.dao;

import com.ekrem.Falcon.model.WorkHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHoursDao extends JpaRepository<WorkHour,Integer> {
}
