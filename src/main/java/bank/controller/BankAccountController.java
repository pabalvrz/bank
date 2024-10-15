package bank.controller;

import bank.model.BankAccount;
import bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create")
    private BankAccount createAccount(BankAccount bankAccount){
        return this.bankAccountService.createAccount(bankAccount);
    }
}
