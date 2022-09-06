package controllers;

import com.team.winners.thirdcycleproject.service.EnterpriseService;
import com.team.winners.thirdcycleproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
}
