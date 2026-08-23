package com.demo.financial_mcp_server.service;

import org.springframework.stereotype.Service;
import com.demo.financial_mcp_server.model.Account;
import com.demo.financial_mcp_server.model.AccountBalance;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankingService {

    private final List<Account> accounts = List.of(

            new Account(
                    "ACC001",
                    "SAVINGS",
                    "INR",
                    new BigDecimal("450000.00")
            ),

            new Account(
                    "ACC002",
                    "CHECKING",
                    "INR",
                    new BigDecimal("125000.50")
            ),

            new Account(
                    "ACC003",
                    "SALARY",
                    "INR",
                    new BigDecimal("275000.00")
            )
    );

    public List<Account> getAccounts() {

        return accounts;
    }

    public AccountBalance getAccountBalance(String accountId) {

        return accounts.stream()
                .filter(account ->
                        account.accountId().equals(accountId))
                .findFirst()
                .map(account ->
                        new AccountBalance(
                                account.accountId(),
                                account.balance(),
                                account.currency()
                        )
                )
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Account not found: " + accountId
                        )
                );
    }
}
