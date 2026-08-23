package com.demo.financial_mcp_server.model;

import java.math.BigDecimal;
public record Account(
            String accountId,
            String accountType,
            String currency,
            BigDecimal balance
    ) {

}
