package com.meroz.servlet;

import javax.servlet.ServletException;

import org.algo.service.ServiceManager;

import com.meroz.service.PortfolioManager;
@SuppressWarnings("serial")

public class InitServlet extends javax.servlet.http.HttpServlet {

	public void init() throws ServletException {
		super.init();

		PortfolioManager pm = new PortfolioManager();
		ServiceManager.setPortfolioManager(pm);
	}
}
