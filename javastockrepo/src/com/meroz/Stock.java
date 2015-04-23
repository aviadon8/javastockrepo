package com.meroz;

import java.text.*;
import java.util.*;

public class Stock {
	private String symbol;
	private Float ask;
	private Float bid;
	private Date date;
			   
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public Stock (String newSymbol, float newBid, float newAsk, Date date){
		this.symbol = newSymbol;
		this.bid = newBid;
		this.ask = newAsk;
		this.date = date;
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

	public String getHtmlDescription() {
		String resultStr = "<b>Stocksymbol</b>: " +this.getSymbol()+  "<b> Bid</b>: " +this.getBid()+ "<b> Ask</b>: " +this.getAsk()+
				"<b> Date:</b> " + this.dateFormat.format(this.getDate());
		return resultStr;
	}
}




















