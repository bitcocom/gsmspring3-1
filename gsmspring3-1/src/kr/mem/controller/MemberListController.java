package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
public class MemberListController implements Controller{	// Servlet -> POJO(Plain Old Java Object)
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			                                    throws ServletException, IOException {
		// 회원전체 리스트 가져오기(Model)
		MemberDAO dao=new MemberDAO();
		List<MemberVO> list=dao.getList();
		// 클라이언트에게 회원리스트를 응답해준다(HTML) : memberList.jsp
		// 객체바인딩 기법
		request.setAttribute("list", list);		
		// 다음페이지경로 리턴
		return "member/memberList.jsp";
		
	}
}
