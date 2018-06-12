package com.hensen.toolbox.portfolio.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {

	@Id
	@GeneratedValue
	private Long id;
	private String symbol;
	private int shares;
}
