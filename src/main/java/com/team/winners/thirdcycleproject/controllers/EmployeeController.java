package com.team.winners.thirdcycleproject.controllers;

import com.team.winners.thirdcycleproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/employee/")
public class EmployeeController  {
    @Autowired
    private EmployeeService employeeService;
}
