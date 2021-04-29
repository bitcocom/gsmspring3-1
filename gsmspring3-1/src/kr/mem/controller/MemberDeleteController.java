package kr.mem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;

public class MemberDeleteController implements Controller{
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			                             throws ServletException, IOException {
		// 파라메터 수집
		int num=Integer.parseInt(request.getParameter("num"));
		MemberDAO dao=new MemberDAO();
		int cnt=dao.memberDelete(num);
		String view="";
		if(cnt>0) {
			// 성공->다시 리스트페이로...
			view="redirect:/m12/memberList.do";
		}else {
			throw new ServletException("error");
		}
		return view;
	}
}
