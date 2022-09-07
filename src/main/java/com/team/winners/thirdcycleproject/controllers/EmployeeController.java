package com.team.winners.thirdcycleproject.controllers;

import com.team.winners.thirdcycleproject.models.Employee;
import com.team.winners.thirdcycleproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/employee/")
public class EmployeeController  {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    private ResponseEntity<List<Employee>> getAllEmployee (){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    private ResponseEntity<Employee> saveEmployee (@RequestBody Employee persona){
        try {
            Employee employeeSaved = employeeService.save(persona);
            return ResponseEntity.created(new URI("/employee/"+employeeSaved.getId())).body(employeeSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deleteEmployee (@PathVariable ("id") Long id){
        return ResponseEntity.ok(employeeService.deleteById(id));
    }
}
