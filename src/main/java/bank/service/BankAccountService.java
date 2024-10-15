package bank.service;

import bank.model.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountService {
    BankAccount createAccount(BankAccount bankAccount);
}
