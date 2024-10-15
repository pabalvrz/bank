package bank.controller;

import bank.model.BankAccount;
import bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/{id}/deposit")
    private BankAccount deposit(@PathVariable Long id, @RequestBody Map<String, Double> body){
        return this.bankAccountService.depositInAccount(id,body.get("amount"));
    }
}
