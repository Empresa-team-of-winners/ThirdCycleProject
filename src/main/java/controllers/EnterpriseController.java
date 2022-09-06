package controllers;

import com.team.winners.thirdcycleproject.service.EmployeeService;
import com.team.winners.thirdcycleproject.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise/")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
}
