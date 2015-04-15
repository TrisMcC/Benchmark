package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07371")
public class BenchmarkTest07371 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55131 = param; //assign
		StringBuilder b55131 = new StringBuilder(a55131);  // stick in stringbuilder
		b55131.append(" SafeStuff"); // append some safe content
		b55131.replace(b55131.length()-"Chars".length(),b55131.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55131 = new java.util.HashMap<String,Object>();
		map55131.put("key55131", b55131.toString()); // put in a collection
		String c55131 = (String)map55131.get("key55131"); // get it back out
		String d55131 = c55131.substring(0,c55131.length()-1); // extract most of it
		String e55131 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55131.getBytes() ) )); // B64 encode and decode it
		String f55131 = e55131.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f55131); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass