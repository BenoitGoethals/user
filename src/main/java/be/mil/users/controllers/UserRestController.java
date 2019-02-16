package be.mil.users.controllers;

import be.mil.users.entitys.User;
import be.mil.users.service.UserService;
import be.mil.users.service.UserServiceDB;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "user", description = "Rest API for user operations", tags = "User API")
public class UserRestController {

    @Autowired
    private UserService userServiceDB;

    private static Logger log = LoggerFactory.getLogger(UserRestController.class);

    @GetMapping("/all")
    @ApiOperation(value = "Display greeting message to non-admin user", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public ResponseEntity<List<User>> getUsers() {

        return  new ResponseEntity<>(userServiceDB.all(), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    @ApiOperation(value = "Display greeting message to non-admin user", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public ResponseEntity<User> getUser(@PathVariable String email){
       return new ResponseEntity<>( userServiceDB.findUserByEmail( email), HttpStatus.OK);
        }



}
