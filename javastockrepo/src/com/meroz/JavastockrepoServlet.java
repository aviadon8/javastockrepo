package com.meroz;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class JavastockrepoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		int num1 = 4;
		int num2 = 3;
		int num3 = 7;
		int result = (num1 + num2) * num3;
		
		String resultStr = new String("Result of (" + num1 + " + " + num2 + ") * " + num3 + " = " + result);
		
		resp.getWriter().println(resultStr);
		
		resp.setContentType("text/html");
		
	}
}
