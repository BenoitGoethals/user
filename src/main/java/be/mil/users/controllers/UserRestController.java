package be.mil.users.controllers;

import be.mil.users.entitys.User;
import be.mil.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    public UserService userService;

    private static Logger log = LoggerFactory.getLogger(UserRestController.class);


    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.all();
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUser() {

        return  new ResponseEntity<>(userService.all(), HttpStatus.OK);
    }



    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email){
       return new ResponseEntity<>( userService.findUserByEmail( email), HttpStatus.OK);
        }



}
