package com.meroz.model;

import java.util.Date;

/**
 * class portfolio hold portfolio of stocks.
 * this class can add or remove stocks to/from the portfolio stocks.
 * @author Aviad_Meroz
 *
 */
public class Portfolio {
	
	private final static int MAX_PORTFOLIO_SIZE = 5;
	
	private String title = new String("stocks portfolio");
	private Stock[] stocks;
	private int portfolioSize = 0;
	
	/**
	 * c'tor of new portfolio.
	 * @param title - the title of portfolio. 
	 */
	public Portfolio(String title){
		this.title = title;
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = portfolioSize;
	}
	
	/**
	 * copy c'tor of portfolio.
	 * @param sourcePortfolio - the portfolio name of copy c'tor.
	 */
	public Portfolio(Portfolio sourcePortfolio){
		this("Portfolio #1");
		this.title = sourcePortfolio.title;
		this.portfolioSize = sourcePortfolio.portfolioSize;
		copyArray(sourcePortfolio.getStocks(), this.getStocks());
	}
	
	/**
	 * this method copy the array of the source array stocks.
	 * @param stocks2 - the new array.
	 * @param stocks - the source array.
	 */
	private void copyArray(Stock[] stocks2, Stock[] stocks){
		
		for(int i = 0 ; i < this.portfolioSize ; i++){
			stocks[i] = new Stock(stocks2[i]); 
		}
	}
	
	/**
	 * this method add new stock into array.
	 * @param stock - the stock received.
	 */
	public void addStock(Stock stock){
		
		if(portfolioSize < MAX_PORTFOLIO_SIZE && stock != null){
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
		else {
			System.out.println("The Portfolio is full / Stock is NULL");
		}
	}
	
	/**
	 * Removes the stocks from portfolio by symbol received.
	 * @param stock - the stock symbol.
	 */
	public void removeStock(String stock){
		
		if(stock == null){
			System.out.println("The stock is wrong");
			return;
		}
			if(this.stocks[portfolioSize-1].getSymbol().equals(stock)){
				this.stocks[portfolioSize-1] = null;
				portfolioSize--;
			} else
			{
				for(int i = 0 ; i < portfolioSize ; i++)
				{
					if(this.stocks[i].getSymbol().equals(stock) && this.stocks[i] != null){
						this.stocks[i] = this.stocks[portfolioSize-1];
						this.stocks[portfolioSize-1] = null;
						portfolioSize--;
					}
				}
			}
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
