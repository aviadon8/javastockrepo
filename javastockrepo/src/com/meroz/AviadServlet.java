package com.meroz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AviadServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		resp.setContentType("text/html");
		
		//calculating circle area
		
		double radius = 50;
		double area = java.lang.Math.PI*radius*radius;
		String circle = new String("Calculation 1: Area of circle with radius: " + radius + " is " + area + " square cm.");

		//calculating opposite area
		float angleB = 30;
		float hypotenuse = 50;
		double opposite = hypotenuse * Math.sin(Math.toRadians(angleB));
		String triangle = new String("Calculation 2: Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: " + opposite + " cm");
		
		//calculating power
		int base = 20;
		int exp = 13;
		long result = (long)Math.pow(base,exp);
		String power = new String("Calculation 3: Power of " + base + " with exp of " + exp + " is " + result);
		
		String resultStr = circle + "<br>" + "<br>" + triangle + "<br>" + "<br>" + power;
        resp.getWriter().println(resultStr);
	}
}