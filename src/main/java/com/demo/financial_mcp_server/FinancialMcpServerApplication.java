package com.demo.financial_mcp_server;

import com.demo.financial_mcp_server.mcp.BankingTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinancialMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialMcpServerApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider bankingToolCallbacks(
			BankingTools bankingTools) {

		return MethodToolCallbackProvider.builder()
				.toolObjects(bankingTools)
				.build();
	}

}
