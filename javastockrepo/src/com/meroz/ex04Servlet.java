package com.meroz;

import java.io.IOException;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;

@SuppressWarnings("serial")
public class ex04Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 10, 15);
		
		Date date1 = cal.getTime();
		Date date2 = cal.getTime();
		Date date3 = cal.getTime();
		
		Stock s1 = new Stock("PIH",13.1F,12.4F,date1);
		Stock s2 = new Stock("AAL",5.78F,5.5F,date2);
		Stock s3 = new Stock("CAAS",32.2F,31.5F,date3);
		
		String str1 = new String(s1.getHtmlDescription());
		String str2 = new String(s2.getHtmlDescription());
		String str3 = new String(s3.getHtmlDescription());
		
		String finalResult = str1+"<br><br>"+str2+"<br><br>"+str3;
		resp.getWriter().println(finalResult);

}
}