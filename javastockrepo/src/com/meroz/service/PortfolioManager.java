package com.meroz.service;

import java.util.Calendar;

import java.util.Date;

import com.meroz.model.Portfolio;
import com.meroz.model.Stock;

/**manage the portfoilio of stocks. 
 * create 3 stocks with their values.
 * include 3 stocks: s1, s2, s3.
 * @author Aviad_Meroz
 *
 */
public class PortfolioManager {

	public Portfolio getPortfolio() {

		String PortfolioTitle = "Exercise 7 portfolio";
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 10, 15);
		
		Date date1 = cal.getTime();
		Date date2 = cal.getTime();
		Date date3 = cal.getTime();
	
		Portfolio myPortfolio = new Portfolio(PortfolioTitle);
		myPortfolio.updateBalance(10000);
		
		Stock s1 = new Stock("PIH",8.5F, 10.0F,date1);
		Stock s2 = new Stock("AAL",25.5F, 30.0F ,date2);
		Stock s3 = new Stock("CAAS",15.5F, 20.0F,date3);
		
		myPortfolio.buyStock(s1, 20);
		myPortfolio.buyStock(s2, 30);
		myPortfolio.buyStock(s3, 40);
		
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		return myPortfolio;
	}
}
