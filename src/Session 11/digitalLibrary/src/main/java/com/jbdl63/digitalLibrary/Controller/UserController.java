package com.jbdl63.digitalLibrary.Controller;

import com.jbdl63.digitalLibrary.Model.User;
import com.jbdl63.digitalLibrary.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<User>> findAllBooksIssuedToUser(@PathVariable("userName") String userName) {
        return new ResponseEntity<>(userService.findAllBooksIssuedToUser(userName), HttpStatus.OK);
    }
}
