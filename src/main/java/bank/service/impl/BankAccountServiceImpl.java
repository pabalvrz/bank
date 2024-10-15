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

    @Override
    public BankAccount depositInAccount(Long id, Double amount) {
        BankAccount bankAccount = this.bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe esa cuenta"));
        bankAccount.setMoney(bankAccount.getMoney() + amount);
        return this.bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount withdrawInAccount(Long id, Double amount) {
        BankAccount bankAccount = this.bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe esa cuenta"));
        Double total = bankAccount.getMoney() - amount;
        if(total < 0 ){
            throw new RuntimeException("Te quedas con menos de 0€ en la cuenta");
        }
        bankAccount.setMoney(total);
        return this.bankAccountRepository.save(bankAccount);
    }
}
