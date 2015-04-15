package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13708")
public class BenchmarkTest13708 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map26484 = new java.util.HashMap<String,Object>();
		map26484.put("keyA-26484", "a_Value"); // put some stuff in the collection
		map26484.put("keyB-26484", param.toString()); // put it in a collection
		map26484.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map26484.get("keyB-26484"); // get it back out
		bar = (String)map26484.get("keyA-26484"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass