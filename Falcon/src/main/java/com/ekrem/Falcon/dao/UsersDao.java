package com.ekrem.Falcon.dao;

import com.ekrem.Falcon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsersDao extends JpaRepository<User,Integer> {




}
