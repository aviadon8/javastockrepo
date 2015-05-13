package com.meroz.model;

import java.text.*;
import java.util.*;

import com.meroz.model.Portfolio.ALGO_RECOMMENDATION;

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
	private Portfolio.ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;

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
		this.stockQuantity = 0;	
	}

	/**
	 * copy c'tor of stock.
	 * @param stock - the stock name of copy c'tor.
	 */
	public Stock(Stock stock){
		this(new String (stock.getSymbol()), stock.getBid(), stock.getAsk(), new Date(stock.getDate().getTime()));
		this.recommendation = stock.recommendation;
		this.stockQuantity = stock.getStockQuantity();
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

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
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
				"<b> Quantity</b>: " + this.getStockQuantity() + "<b> Date:</b> " + this.dateFormat.format(this.getDate());
		return resultStr;
	}
}




















