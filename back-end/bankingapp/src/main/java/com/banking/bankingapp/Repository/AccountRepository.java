package com.banking.bankingapp.Repository;

import com.banking.bankingapp.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
