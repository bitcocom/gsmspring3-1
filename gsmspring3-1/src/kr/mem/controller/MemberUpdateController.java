package kr.mem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                throws ServletException, IOException {
		// 파라메터수집(VO)
		// 0. 한글인코딩
				request.setCharacterEncoding("utf-8");				
				// 1. 클라이언트에서 넘어온 파라메터를 수집(VO)
				int num=Integer.parseInt(request.getParameter("num"));
				int age=Integer.parseInt(request.getParameter("age"));
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				
				MemberVO vo=new MemberVO();
                vo.setNum(num);  
				vo.setAge(age);
		        vo.setPhone(phone);
		        vo.setEmail(email);
		        
		        MemberDAO dao=new MemberDAO();
		        int cnt=dao.memberUpdate(vo);
		        if(cnt>0) {
		        	response.sendRedirect("/m1/memberList.do");
		        }else {
		        	throw new ServletException("error");
		        }		        
	}
}
