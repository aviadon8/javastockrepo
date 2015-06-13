package com.meroz.exception;

import org.algo.exception.PortfolioException;

public class StockNotExistException extends PortfolioException{

	public StockNotExistException (String symbol){
		super("This Stock [" + symbol + "]" + "not exsits");
	}
}
