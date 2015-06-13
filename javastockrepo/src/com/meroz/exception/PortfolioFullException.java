package com.meroz.exception;

import org.algo.exception.PortfolioException;

public class PortfolioFullException extends PortfolioException {

	public PortfolioFullException() {
		super("Portfolio is full, first sell and then buy more");
	}

}
