package com.meroz.servlet;

import java.io.IOException;

import javax.servlet.http.*;

import com.meroz.model.Portfolio;
import com.meroz.service.PortfolioManager;

@SuppressWarnings("serial")
/**
 * class portfolioServlet, extends attributes from class HttpServlet.
 * @author Aviad_Meroz
 *
 */
public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio = portfolioManager.getPortfolio();
		
		
		Portfolio portfolio2 = new Portfolio(portfolio);
		portfolio2.setTitle("Portfolio #2");
		
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio.removeStock(portfolio.getStocks()[0].getSymbol());
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio2.getStocks()[portfolio2.getPortfolioSize()-1].setBid(55.55f);
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
	}
}