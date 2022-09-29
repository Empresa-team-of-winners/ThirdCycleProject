package com.team.winners.thirdcycleproject.controllers;

import com.team.winners.thirdcycleproject.models.Enterprise;
import com.team.winners.thirdcycleproject.models.Transaction;
import com.team.winners.thirdcycleproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/indexTransaction")
    public String viewHomePage(Model model) {
        return findPaginated(1, "concept", "asc", model);
    }


    @GetMapping("/showNewTransactionForm")
    public String showNewEnterpriseForm(Model model) {
        // create model attribute to bind form data
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "new_transaction";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {
        // save employee to database
        transactionService.save(transaction);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdateTransaction/{id}")
    public String showFormForUpdateTransaction(@PathVariable ( value = "id") Integer id, Model model) {

        // get employee from the service
        Optional<Transaction> transaction = transactionService.findById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("transaction", transaction);
        return "update_transaction";
    }

    @GetMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable (value = "id") Integer id) {

        // call delete employee method
        this.transactionService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/pageTransaction/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Transaction> page = transactionService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Transaction> listTransactions = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listTransactions", listTransactions);
        return "index_transaction.html";
    }
}
