package com.team.winners.thirdcycleproject.controllers;

import com.team.winners.thirdcycleproject.models.Enterprise;
import com.team.winners.thirdcycleproject.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enterprise/")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    private ResponseEntity<List<Enterprise>> getAllEnterprise (){return ResponseEntity.ok(enterpriseService.findAll());}

    @PostMapping
    private ResponseEntity<Enterprise> saveEnterprise (@RequestBody Enterprise enterprise){
        try {
            Enterprise enterpriseSaved = enterpriseService.save(enterprise);
            return ResponseEntity.created(new URI("/enterprise/"+enterpriseSaved.getId())).body(enterpriseSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deleteEnterprise (@PathVariable ("id") Long id){
        return ResponseEntity.ok(enterpriseService.deleteById(id));
    }
}
