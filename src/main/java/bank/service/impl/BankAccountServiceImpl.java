package bank.service.impl;

import bank.model.BankAccount;
import bank.repository.BankAccountRepository;
import bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount createAccount(BankAccount bankAccount) {
        return this.bankAccountRepository.save(bankAccount);
    }

    @Override
    public List<BankAccount> listAll() {
        return this.bankAccountRepository.findAll();
    }

    @Override
    public BankAccount findById(Long id) {
        return this.bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe esa cuenta"));
    }
}
