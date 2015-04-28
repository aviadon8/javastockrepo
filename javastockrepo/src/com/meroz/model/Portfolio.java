package com.meroz.model;

import java.util.Date;
import com.meroz.Stock;

public class Portfolio {
	
	private final static int MAX_PORTFOLIO_SIZE = 5;
	
	private String title = new String("stocks portfolio");
	private Stock[] stocks;
	private int portfolioSize = 0;

	public Portfolio(){
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public void addStock(Stock stock){
		stocks[portfolioSize] = stock;
		portfolioSize++;
	}
	
	public Stock[] getStock(){
		return stocks;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Stock[] getStocks() {
		return stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}
	
	public String getHtmlString() {
		
		String resultStr = "<h1>" + title + "</h1>";
		
		for(int i = 0; i < portfolioSize; i++) {
			resultStr += stocks[i].getHtmlDescription() +"<br>";
		}
		return resultStr;
	}
}
