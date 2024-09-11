package com.banking.bankingapp.Mapper;

import com.banking.bankingapp.DTO.AccountDTO;
import com.banking.bankingapp.Entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDTO accountDTO) {
        Account account = new Account(
                accountDTO.getId(),
                accountDTO.getAccountHolderName(),
                accountDTO.getBalance()
        );
        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDTO;
    }
}
