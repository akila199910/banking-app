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
}
