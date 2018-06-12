package com.hensen.toolbox.portfolio.service;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioRestController {

	private final PortfolioRepository portfolioRepository;
	
	public PortfolioRestController(PortfolioRepository portfolioRepository) {
		this.portfolioRepository = portfolioRepository;
	}
	
	@GetMapping("/portfolios")
	Collection<Portfolio> portfolios() {
		return portfolioRepository.findAll();
	}
}
