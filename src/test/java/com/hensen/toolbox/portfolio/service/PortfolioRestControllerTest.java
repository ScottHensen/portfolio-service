package com.hensen.toolbox.portfolio.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;

@WebMvcTest
@RunWith(SpringRunner.class)
public class PortfolioRestControllerTest {

	@MockBean
	private PortfolioRepository portfolioRepository;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void givenHttpRequest_whenGetPortfolio_thenAllPortfoliosReturned() throws Exception {
		
		Mockito.when(this.portfolioRepository.findAll())
				.thenReturn(Collections.singletonList(new Portfolio(null, "TSLA", 100)));
		
		this.mvc.perform(MockMvcRequestBuilders.get("/portfolios"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("@.[0].symbol").value("TSLA"));
	}
}
