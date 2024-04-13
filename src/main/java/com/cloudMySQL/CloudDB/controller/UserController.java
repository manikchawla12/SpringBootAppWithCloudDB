package com.cloudMySQL.CloudDB.controller;

import com.cloudMySQL.CloudDB.entity.User;
import com.cloudMySQL.CloudDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/demo")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/addUser")
    public @ResponseBody User addNewUser(@RequestBody User requst){
       String name=requst.getName();
       String address=requst.getAddress();

        User user=new User();
        user.setName(name);
        user.setAddress(address);
        userRepository.save(user);
        return user;
    }

    @GetMapping(value = "/getUsers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
