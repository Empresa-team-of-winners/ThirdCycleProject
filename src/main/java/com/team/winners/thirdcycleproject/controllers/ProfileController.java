package com.team.winners.thirdcycleproject.controllers;
import com.team.winners.thirdcycleproject.models.Employee;
import com.team.winners.thirdcycleproject.models.Profile;
import com.team.winners.thirdcycleproject.service.EmployeeService;
import com.team.winners.thirdcycleproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @GetMapping
    private ResponseEntity<List<Profile>> getAllEmployee (){return ResponseEntity.ok(profileService.findAll());}

    @PostMapping
    private ResponseEntity<Profile> saveEmployee (@RequestBody Profile perfil){
        try {
            Profile profileSaved = profileService.save(perfil);
            return ResponseEntity.created(new URI("/profile/"+profileSaved.getId())).body(profileSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
