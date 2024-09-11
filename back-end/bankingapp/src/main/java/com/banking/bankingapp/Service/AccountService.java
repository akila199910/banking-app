package com.banking.bankingapp.Service;

import com.banking.bankingapp.DTO.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long id);
    AccountDTO deposit(Long id, double amount);
    AccountDTO withdraw(Long id, double amount);
    List<AccountDTO> getAllAccounts();
    void deleteAccount(Long id);

}
