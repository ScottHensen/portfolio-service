package com.hensen.toolbox.portfolio.service;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@RunWith(SpringRunner.class)
//@DirtiesContext
//@AutoConfigureMessageVerifier
public abstract class BaseClass {

	@MockBean
	private PortfolioRepository portfolioRepository;
	
	@Autowired
	private PortfolioRestController portfolioRestController;
	
	@Before
	public void before() {
		
        //body( [ [ id: 1L, symbol: "TSLA", shares: 100 ], [ id: 2L, symbol: "AMZN", shares: 50 ] ] )
		Mockito
			.when(this.portfolioRepository.findAll())
			.thenReturn(Arrays.asList(new Portfolio(1L, "TSLA", 100),
									  new Portfolio(2L, "AMZN", 50)));
		
		RestAssuredMockMvc.standaloneSetup(this.portfolioRestController);
	}
}
