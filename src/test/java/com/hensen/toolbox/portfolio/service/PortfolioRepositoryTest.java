package com.hensen.toolbox.portfolio.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PortfolioRepositoryTest {

	@Autowired
	private PortfolioRepository repository;
	
	@Test
	public void shouldPersist() {
		
		Portfolio p = repository.save(new Portfolio(1L, "TSLA", 100));
		Assertions.assertThat(p.getId()).isNotNull();
		Assertions.assertThat(p.getSymbol()).isEqualToIgnoringCase("TSLA");
		Assertions.assertThat(p.getShares()).isEqualTo(100);
	}
}
