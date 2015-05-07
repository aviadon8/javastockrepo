package com.meroz.model;

import java.text.*;

import java.util.*;

/**
 * class stock responsible on the structure of the stocks.
 * @author Aviad_Meroz
 *
 */
public class Stock {
	private String symbol;
	private Float ask;
	private Float bid;
	private Date date;
	private int recommendation;
	private int stockQuantity;
	private final static int BUY = 0;
	private final static int SELL = 1;
	private final static int REMOVE = 2;
	private final static int HOLD = 3;
			   
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * c'tor of new stock.
	 * @param newSymbol - the name of stock.
	 * @param newBid - the bid of stock.
	 * @param newAsk - the new ask of stock.
	 * @param date - the date of stock.
	 */
	public Stock (String newSymbol, float newBid, float newAsk, Date date){
		this.symbol = newSymbol;
		this.bid = newBid;
		this.ask = newAsk;
		this.date = date;
		
	}
	
	/**
	 * copy c'tor of stock.
	 * @param stock - the stock name of copy c'tor.
	 */
	public Stock(Stock stock){
		this(new String (stock.getSymbol()), stock.getBid(), stock.getAsk(), new Date(stock.getDate().getTime()));
		this.recommendation = stock.recommendation;
		this.stockQuantity = stock.stockQuantity;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Float getAsk() {
		return ask;
	}

	public void setAsk(Float ask) {
		this.ask = ask;
	}

	public Float getBid() {
		return bid;
	}

	public void setBid(Float bid) {
		this.bid = bid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getHtmlDescription() {
		String resultStr = "<b>Stocksymbol</b>: " +this.getSymbol()+  "<b> Bid</b>: " +this.getBid()+ "<b> Ask</b>: " +this.getAsk()+
				"<b> Date:</b> " + this.dateFormat.format(this.getDate());
		return resultStr;
	}
}




















