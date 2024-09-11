package com.banking.bankingapp.Service.Impl;

import com.banking.bankingapp.DTO.AccountDTO;
import com.banking.bankingapp.Entity.Account;
import com.banking.bankingapp.Mapper.AccountMapper;
import com.banking.bankingapp.Repository.AccountRepository;
import com.banking.bankingapp.Service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.mapToAccount(accountDTO);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(saveAccount);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        Account account =accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        return AccountMapper.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        double total = account.getBalance() +amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        if(account.getBalance()-amount<0){
            throw new RuntimeException("Insufficient balance");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }
}
