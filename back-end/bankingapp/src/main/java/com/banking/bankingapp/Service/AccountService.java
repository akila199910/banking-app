package com.banking.bankingapp.Service;

import com.banking.bankingapp.DTO.AccountDTO;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long id);
    AccountDTO deposit(Long id, double amount);

}
