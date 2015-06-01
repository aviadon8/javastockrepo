package com.meroz.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;
import org.algo.model.*;

/**
 * class portfolio hold portfolio of stocks.
 * this class can add or remove stocks to/from the portfolio stocks.
 * @author Aviad_Meroz
 *
 */
public class Portfolio implements PortfolioInterface {

	public enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};

	private final static int MAX_PORTFOLIO_SIZE = 5;

	private String title;
	private StockInterface[] stocks;
	private int portfolioSize;
	private float balance = 0;

	/**
	 * Empty c'tor of new portfolio.
	 */
	public Portfolio() {
		this.title = null;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0; 
		this.balance = 0 ;
	}

	/**
	 * c'tor of new portfolio.
	 * @param stockArray - array of stock.
	 */
	public Portfolio(Stock[] stockArray) {
		this.title = null;
		this.portfolioSize = stockArray.length;
		this.balance = 0;
		this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE];
		for(int i = 0; i<this.portfolioSize; i++){
			this.stocks[i]= new Stock ((Stock)stockArray[i]);
		}
	}

	/**
	 * c'tor of new portfolio.
	 * @param title - the title of portfolio. 
	 */
	public Portfolio(String title){
		this.title = title;
		this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		this.balance = 0;
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
	 * @param stock - the new array.
	 * @param stock2 - the source array.
	 */
	private void copyArray(StockInterface[] stockInterfaces, StockInterface[] stockInterfaces2){

		for(int i = 0 ; i < this.portfolioSize ; i++){
			stockInterfaces2[i] = new Stock((Stock) stockInterfaces[i]); 
		}
	}

	/** 
	 * this method update the Balance - the money available in portfolio for investments
	 * @param amount
	 */
	public void updateBalance(float amount){

		float tempBalance = amount + this.balance;

		if(tempBalance < 0){
			System.out.println("Not enough money in portfolio.");
			return;
		} else{
			this.balance = tempBalance;	
			return;
		}
	}

	/**
	 * this method add new stock into array.
	 * @param stock - the stock received.
	 */
	public void addStock(Stock stock){

		if (portfolioSize < MAX_PORTFOLIO_SIZE && stock != null){
			for(int i = 0 ; i < portfolioSize ; i++){
				if(this.stocks[i].getSymbol().equals(stock.getSymbol())){
					return;
				}
			}
			stock.setStockQuantity(0);
			stocks[portfolioSize] = stock;
			portfolioSize++;
		} else if (stock == null){
			System.out.println("your stock is invalid");
		} else if (portfolioSize > MAX_PORTFOLIO_SIZE){
			System.out.println("Can’t add new stock, portfolio can have only" + MAX_PORTFOLIO_SIZE + "stocks");
		}
	}

	/**
	 * this method sell a stock (but not remove it from portfolio).
	 * @param symbol- which stock to sell.
	 * @param quantity - Number of this symbol’s stock to sell
						i. if quantity = ­1 the method sell whole quantity of this stock.
	 * @return
	 */
	public boolean sellStock(String symbol, int quantity){

		if(symbol == null || quantity < -1){
			System.out.println("There is an error! Please check your stock symbol or stock quntity.");
			return false;
		}

		for(int i = 0; i< this.portfolioSize; i++){

			if(this.stocks[i].getSymbol().equals(symbol) == true){
				if(((Stock) this.stocks[i]).getStockQuantity() - quantity < 0){
					System.out.println("Not enough stocks to sell");
					return false;

				}else if(quantity == -1){
					this.updateBalance((((Stock) this.stocks[i]).getStockQuantity() * this.stocks[i].getBid()));
					((Stock) this.stocks[i]).setStockQuantity(0);
					System.out.println("Entire stock ("+symbol+") was sold succefully");
					return true;

				}else {
					this.updateBalance(quantity * this.stocks[i].getBid());
					((Stock) this.stocks[i]).setStockQuantity(((Stock) stocks[i]).getStockQuantity()-quantity);
					System.out.println("An amount of "+quantity+" of stock ("+symbol+") was sold succefully");
					return true;
				}
			}

		}
		System.out.println("Stock wasn't found in Portfolio, you can't sell");
		return false; 
	}

	/**
	 * this method buy a stock.
	 * @param stock - the stock we want to buy.
	 * @param quantity - if quantity = ­1 means buy this stock with the full balance sum.
	 * @return
	 */
	public boolean buyStock(Stock stock, int quantity){

		if (findStock(stock.getSymbol()) == null){
			addStock(stock);
		}	
		if (quantity < 1 && quantity != -1) {
			System.out.println("Stock quantity is invalid");
			return false;

		}else if (getBalance() < (quantity * stock.getAsk())) {
			System.out.println("Not enough balance to buy this quantity of new stocks ");
			return false;

		} else if(quantity == -1){
			float tempBuyQuantity = balance/stock.getAsk();
			int buyQuantity;
			buyQuantity = (int)tempBuyQuantity;
			this.updateBalance(-buyQuantity * stock.getAsk());
			stock.setStockQuantity(stock.getStockQuantity() + buyQuantity);
			System.out.println("Entire stock ("+stock.getSymbol()+") holdings was sold succefully");
			return true;

		}else{
			this.updateBalance(-quantity * stock.getAsk());
			stock.setStockQuantity(stock.getStockQuantity() + quantity);
			System.out.println("An amount of "+quantity+" of stock ("+stock.getSymbol()+") was bought succefully");
			return true;

		}
	}

	/**
	 * this method searching stock in the array of portfolio. return true or false.
	 * @param stock - the stock we want to search.
	 * @return
	 */
	public StockInterface findStock(String symbol) {

		for (int i = 0; i < getPortfolioSize(); i++) {
			if (getStocks()[i].getSymbol().equals(symbol)){
				return this.getStocks()[i];
			}
		}
		return null;
	}

	/**
	 * Removes the stocks from portfolio by symbol received.
	 * @param stock - the stock symbol.
	 */
	public void removeStock(String stock){

		this.sellStock(stock, -1);
		if(stock == null){
			System.out.println("The stock is wrong");
			return;
		}
		for(int i = 0 ; i < portfolioSize ; i++)
		{
			if(this.stocks[i].getSymbol().equals(stock)){
				this.stocks[i] = this.stocks[portfolioSize-1];
				this.stocks[portfolioSize-1] = null;
				portfolioSize--;
			}
		}
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StockInterface[] getStocks() {
		return stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public float getBalance() {
		return balance;
	}

	public static int getMaxSize() {

		return MAX_PORTFOLIO_SIZE;
	}

	public float getStocksValue(){
		float stocksValue =0;
		for(int i = 0 ; i < portfolioSize ; i++){
			stocksValue += ((Stock) this.stocks[i]).getStockQuantity() * this.stocks[i].getBid();
		}
		return stocksValue;
	}

	public float getTotalValue(){
		return getBalance() + getStocksValue();
	}

	public String getHtmlString() {

		String resultStr = "<h1>" + this.title + "</h1>";

		for(int i = 0; i < portfolioSize; i++) {
			resultStr += ((Stock) stocks[i]).getHtmlDescription() +"<br>" ;
		}

		resultStr += "Total Portfolio Value :"+this.getTotalValue()+ "$, "
				+  "Total Stocks Value :"+this.getStocksValue()+"$, "
				+  "Balance :"+this.balance+"$.";
		return resultStr;
	}
}