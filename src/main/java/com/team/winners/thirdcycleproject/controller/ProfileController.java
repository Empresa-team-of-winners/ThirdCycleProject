package com.team.winners.thirdcycleproject.controller;
import com.team.winners.thirdcycleproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileController {
    @Autowired
    private ProfileService profileService;

}
