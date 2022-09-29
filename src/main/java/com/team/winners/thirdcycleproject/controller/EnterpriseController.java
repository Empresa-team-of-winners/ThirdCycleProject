package com.team.winners.thirdcycleproject.controller;

import com.team.winners.thirdcycleproject.models.Enterprise;
import com.team.winners.thirdcycleproject.models.User;
import com.team.winners.thirdcycleproject.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/indexEnterprise")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }


    @GetMapping("/showNewEnterpriseForm")
    public String showNewEnterpriseForm(Model model) {
        // create model attribute to bind form data
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "new_enterprise";
    }

    @PostMapping("/saveEnterprise")
    public String saveEnterprise(@ModelAttribute("enterprise") Enterprise enterprise) {
        // save employee to database
        enterpriseService.save(enterprise);
        return "redirect:/indexEnterprise";
    }

    @GetMapping("/showFormForUpdateEnterprise/{id}")
    public String showFormForUpdateEnterprise(@PathVariable ( value = "id") Integer id, Model model) {

        // get employee from the service
        Optional<Enterprise> enterprise = enterpriseService.findById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("enterprise", enterprise);
        return "update_enterprise";
    }

    @GetMapping("/deleteEnterprise/{id}")
    public String deleteEnterprise(@PathVariable (value = "id") Integer id) {

        // call delete employee method
        this.enterpriseService.deleteById(id);
        return "redirect:/indexEnterprise";
    }


    @GetMapping("/pageEnterprise/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Enterprise> page = enterpriseService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Enterprise> listEnterprises = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEnterprises", listEnterprises);
        return "index_enterprise.html";
    }

    @GetMapping("/allEnterprises")
    private ResponseEntity<List<Enterprise>> getAllEnterprise (){
        return ResponseEntity.ok(enterpriseService.findAll());
    }
}
