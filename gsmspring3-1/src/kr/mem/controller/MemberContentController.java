package kr.mem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 파라메터수집
		int num=Integer.parseInt(request.getParameter("num"));
		MemberDAO dao=new MemberDAO();
		MemberVO vo=dao.memberContent(num);
		//객체바인딩
		request.setAttribute("vo", vo);
		RequestDispatcher rd=request.getRequestDispatcher("member/memberContent.jsp");
		rd.forward(request, response);
	}
}
