package com.meroz.exception;

import org.algo.exception.PortfolioException;

public class StockAlreadyExistsException extends PortfolioException {

	public StockAlreadyExistsException (String symbol){
		super("This Stock [" + symbol + "]" + " allready exsits");
	}
}
