package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MyUtil;

//JavaSE->JavaEE(Servlet)
@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
			                                      throws ServletException, IOException {
	      // 1~100=짝수의 합을?
		  MyUtil my=new MyUtil();
		  int v=my.hap();
		  PrintWriter out=response.getWriter(); //클라이언트에 연결된 빨대
		  out.println("<html>");
		  out.println("<body>");
		  out.println("<table border='1'>");
		  out.println("<tr>");
		  out.println("<td>TOTAL</td>");
		  out.println("<td>"+v+"</td>");
		  out.println("</tr>");
		  out.println("</table>");
		  out.println("</body>");
		  out.println("</html>");	  
	}
}