package bank.service;

import bank.model.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankAccountService {
    BankAccount createAccount(BankAccount bankAccount);

    List<BankAccount> listAll();

    BankAccount findById(Long id);

    BankAccount depositInAccount(Long id, Double amount);
}
