package com.hensen.toolbox.portfolio.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PortfolioTest {

	@Test
	public void shouldConstructPortfolio() {
	
		Portfolio p = new Portfolio(1L, "TSLA", 100);
		Assertions.assertThat(p.getSymbol()).isEqualTo("TSLA");
	}
}
