package kr.mem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                 throws ServletException, IOException {
		// 1. 클라이언트에서 넘어온 파라메터를 수집(VO)
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
        vo.setPhone(phone);
        vo.setEmail(email);
        
        // 2. Model과 연동하는 작업
        MemberDAO dao=new MemberDAO();
        int cnt=dao.memberInsert(vo);
        if(cnt>0) {
        	//성공->다시 리스트페이지로 경로를 변경해주면된다.
        	response.sendRedirect("/m1/memberList.do");
        }else {
        	throw new ServletException("error");
        }
	}

}