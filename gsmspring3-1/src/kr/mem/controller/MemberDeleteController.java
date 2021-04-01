package kr.mem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                             throws ServletException, IOException {
		// 파라메터 수집
		int num=Integer.parseInt(request.getParameter("num"));
		MemberDAO dao=new MemberDAO();
		int cnt=dao.memberDelete(num);
		if(cnt>0) {
			// 성공->다시 리스트페이로...
			response.sendRedirect("/m1/memberList.do");
		}else {
			throw new ServletException("error");
		}
	}
}
