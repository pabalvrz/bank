package bank.controller;

import bank.model.BankAccount;
import bank.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bankAccount")
@Tag(name = "BankAccount", description = "Controlador dencargado de las cuentas del banco")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @Operation(
            summary = "Create account",
            description = "Create account giving name and initial amount")
    @PostMapping("/create")
    private BankAccount createAccount(@RequestBody BankAccount bankAccount){
        return this.bankAccountService.createAccount(bankAccount);
    }

    @Operation(
            summary = "Retrieve all bank accounts",
            description = "Return the info of all the bank accounts on the system")
    @GetMapping("/")
    private List<BankAccount> getAllAccount(){
        return this.bankAccountService.listAll();
    }

    @Operation(
            summary = "Retrieve an specific bank account",
            description = "Return the info of the bank account giving an id")
    @GetMapping("/{id}")
    private BankAccount getAccount(@PathVariable Long id){
        return this.bankAccountService.findById(id);
    }

    @Operation(
            summary = "Deposit money on the account",
            description = "Return the info of the bank account after depositing money")
    @PostMapping("/{id}/deposit")
    private BankAccount deposit(@PathVariable Long id, @RequestBody Map<String, Double> body){
        return this.bankAccountService.depositInAccount(id,body.get("amount"));
    }

    @Operation(
            summary = "Withdraww money of the account",
            description = "Return the info of the bank account after withdrawing money")
    @PostMapping("/{id}/withdraw")
    private BankAccount withdraw(@PathVariable Long id, @RequestBody Map<String, Double> body){
        return this.bankAccountService.withdrawInAccount(id,body.get("amount"));
    }


}
