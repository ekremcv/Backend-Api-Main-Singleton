package com.ekrem.Falcon.service;


import com.ekrem.Falcon.dao.UsersDao;
import com.ekrem.Falcon.dto.AssignmentProjectDto;
import com.ekrem.Falcon.dto.UserDto;

import com.ekrem.Falcon.dto.UserDtoFilter;
import com.ekrem.Falcon.model.AssignProject;
import com.ekrem.Falcon.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    UsersDao usersDao;

    

    public ResponseEntity<List<UserDtoFilter>> getAllUsers() {

        try{
            return new ResponseEntity<>(usersDao.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList()), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> addUser(User user) {
        usersDao.save(user);
        return new ResponseEntity<>("Successful",HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteUser(Integer userid) {
        try {
            usersDao.deleteById(userid);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>("User not deleted.Because this user is a project supervisor", HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> updateUser(User user,Integer userid) {
        usersDao.findById(userid);
        usersDao.save(user);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }


    private UserDto convertEntityToDtoWithAp(User user){
        UserDto userDto=new UserDto();
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setAssignmentProjectList(user.getAssignProjectList());
        return userDto;



    }
    private UserDtoFilter convertEntityToDto(User user){
        UserDtoFilter userDtoFilter= new UserDtoFilter();
        userDtoFilter.setFirstname(user.getFirstname());
        userDtoFilter.setLastname(user.getLastname());
        userDtoFilter.setEmail(user.getEmail());
        return userDtoFilter;



    }

    public ResponseEntity<List<UserDto>> getAllUsersWithAP() {

        try{
            return new ResponseEntity<>(usersDao.findAll().stream().map(this::convertEntityToDtoWithAp).collect(Collectors.toList()), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    }

