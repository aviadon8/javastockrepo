package com.meroz.service;

import java.util.Calendar;
import java.util.Date;

import com.meroz.Stock;
import com.meroz.model.Portfolio;

public class PortfolioManager {

	public Portfolio getPortfolio() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 10, 15);
		
		Date date1 = cal.getTime();
		Date date2 = cal.getTime();
		Date date3 = cal.getTime();
		
		Portfolio portfolio = new Portfolio();
		
		Stock s1 = new Stock("PIH",13.1F,12.4F,date1);
		Stock s2 = new Stock("AAL",5.78F,5.5F,date2);
		Stock s3 = new Stock("CAAS",32.2F,31.5F,date3);
		
		portfolio.addStock(s1);
		portfolio.addStock(s2);
		portfolio.addStock(s3);
		
		return portfolio;
	}
}
