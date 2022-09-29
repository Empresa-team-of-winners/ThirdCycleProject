package com.team.winners.thirdcycleproject.controllers;
import com.team.winners.thirdcycleproject.models.Profile;
import com.team.winners.thirdcycleproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@Controller
public class ProfileController {
    @Autowired
    private ProfileService profileService;

}
