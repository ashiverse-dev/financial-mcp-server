package com.demo.financial_mcp_server.mcp;

import com.demo.financial_mcp_server.model.Account;
import com.demo.financial_mcp_server.model.AccountBalance;
import com.demo.financial_mcp_server.service.BankingService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingTools {
    private final BankingService bankingService;

    public BankingTools(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @Tool(name = "get_accounts",
            description = """
                    Get all bank accounts belonging to the customer.
                    Returns account ID, account type, currency and balance.
                    Use this when the customer asks about their bank accounts.
                    """)
    public List<Account> getAccounts() {
        return bankingService.getAccounts();
    }


    @Tool(name = "get_account_balance",description = """
                    Get the current balance of a specific bank account.
                    Requires the account ID.
                    """)
    public AccountBalance getAccountBalance(@ToolParam(description = "The unique bank account ID") String accountId) {
        return bankingService.getAccountBalance(accountId);
    }
}
