package bank.controller;

import bank.model.BankAccount;
import bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create")
    private BankAccount createAccount(@RequestBody BankAccount bankAccount){
        return this.bankAccountService.createAccount(bankAccount);
    }

    @GetMapping("/")
    private List<BankAccount> getAllAccount(){
        return this.bankAccountService.listAll();
    }

    @GetMapping("/{id}")
    private BankAccount getAccount(@PathVariable Long id){
        return this.bankAccountService.findById(id);
    }
}
