package com.team.winners.thirdcycleproject.controller;

import com.team.winners.thirdcycleproject.models.User;
import com.team.winners.thirdcycleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "email", "asc", model);
    }


    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("user") User user) {
        // save employee to database
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdateUser/{id}")
    public String showFormForUpdateUser(@PathVariable ( value = "id") Integer id, Model model) {

        // get employee from the service
        Optional<User> user = userService.findById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") Integer id) {

        // call delete employee method
        this.userService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> listUsers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUsers", listUsers);
        return "index";
    }

}
