package com.team.winners.thirdcycleproject.controllers;

import com.team.winners.thirdcycleproject.models.Employee;
import com.team.winners.thirdcycleproject.models.User;
import com.team.winners.thirdcycleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<List<User>> getAllUser (){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    private ResponseEntity<User> saveUser (@RequestBody User user){
        try {
            User userSaved = userService.save(user);
            return ResponseEntity.created(new URI("/user/"+userSaved.getId())).body(userSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        Optional<User> userData = userService.findById(id);
        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setEmail(user.getEmail());
            return new ResponseEntity<>(userService.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<User> getUserlById(@PathVariable("id") Integer id) {
        Optional<User> userData = userService.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deleteUser (@PathVariable ("id") Integer id){
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
