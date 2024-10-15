package bank.controller;

import bank.model.BankAccount;
import bank.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    private ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount bankAccount){
        return new ResponseEntity<>(this.bankAccountService.createAccount(bankAccount),HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve all bank accounts",
            description = "Return the info of all the bank accounts on the system")
    @GetMapping("/")
    private ResponseEntity<List<BankAccount>> getAllAccount(){
        return new ResponseEntity<>(this.bankAccountService.listAll(),HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve an specific bank account",
            description = "Return the info of the bank account giving an id")
    @GetMapping("/{id}")
    private ResponseEntity<BankAccount> getAccount(@PathVariable Long id){
        return new ResponseEntity<>(this.bankAccountService.findById(id),HttpStatus.OK);
    }

    @Operation(
            summary = "Deposit money on the account",
            description = "Return the info of the bank account after depositing money")
    @PostMapping("/{id}/deposit")
    private ResponseEntity<BankAccount> deposit(@PathVariable Long id, @RequestBody Map<String, Double> body){
        return new ResponseEntity<>(this.bankAccountService.depositInAccount(id,body.get("amount")),HttpStatus.OK);
    }

    @Operation(
            summary = "Withdraww money of the account",
            description = "Return the info of the bank account after withdrawing money")
    @PostMapping("/{id}/withdraw")
    private ResponseEntity<BankAccount> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> body){
        return new ResponseEntity<>(this.bankAccountService.withdrawInAccount(id,body.get("amount")),HttpStatus.OK);
    }


}
