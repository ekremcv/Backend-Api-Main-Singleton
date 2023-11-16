package com.ekrem.Falcon.controller;



import com.ekrem.Falcon.dto.UserDto;
import com.ekrem.Falcon.dto.UserDtoFilter;
import com.ekrem.Falcon.model.User;
import com.ekrem.Falcon.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsersController {

    @Autowired
    UsersService usersService;


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDtoFilter>> getAllUsers(){
        return usersService.getAllUsers();
    }
    @GetMapping("/getAllUsersWithAP")
    public ResponseEntity<List<UserDto>> getAllUsersWithAp(){
        return usersService.getAllUsersWithAP();
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addUser(@RequestBody User user){
        return usersService.addUser(user);
    }

    @DeleteMapping("delete/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userid){
        return usersService.deleteUser(userid);
    }

    @PutMapping("update/{userid}")
    public ResponseEntity<String>  updateUser(@RequestBody User user,@PathVariable Integer userid){
        return usersService.updateUser(user,userid);
    }
}
