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

		resp.getWriter().println(portfolio.getHtmlString());

	}
}