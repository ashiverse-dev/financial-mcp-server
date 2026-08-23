package com.demo.financial_mcp_server.model;

import java.math.BigDecimal;

public record AccountBalance(
        String accountId,
        BigDecimal availableBalance,
        String currency
) {
}
