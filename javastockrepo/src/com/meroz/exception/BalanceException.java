package com.meroz.exception;

import org.algo.exception.PortfolioException;

public class BalanceException extends PortfolioException{

	public BalanceException(){
		super("Not enough balance in your portfolio");
	}

	public BalanceException(String error){
		super(error);
	}
}