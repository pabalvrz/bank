package bank.service.impl;

import bank.model.BankAccount;
import bank.repository.BankAccountRepository;
import bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount createAccount(BankAccount bankAccount) {
        return this.bankAccountRepository.save(bankAccount);
    }
}
