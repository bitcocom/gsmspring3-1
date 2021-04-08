package kr.mem.frontcontroller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;

@WebServlet("*.do")
// MVC->MVC변형(FrontController등장)
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	  request.setCharacterEncoding("utf-8");	
	  // memberList.do
	  // memberInsert.do
      // 1 클라이언트의 요청을 확인하는 작업
	  String reqPath=request.getRequestURI();	
	  System.out.println(reqPath);
	  String ctx=request.getContextPath();
	  System.out.println(ctx);
	  
	  String command=reqPath.substring(ctx.length());
	  System.out.println(command);
	  
	  // 각 요청에 따른 작업하기(분기 작업)
	  if(command.equals("/memberList.do")) {
			// 회원전체 리스트 가져오기(Model)
			MemberDAO dao=new MemberDAO();
			List<MemberVO> list=dao.getList();
			// 클라이언트에게 회원리스트를 응답해준다(HTML) : memberList.jsp
			// 객체바인딩 기법
			request.setAttribute("list", list);		
			// forward 기법
			RequestDispatcher rd=request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);
		  
	  }else if(command.equals("/memberDelete.do")) {
		    int num=Integer.parseInt(request.getParameter("num"));
			MemberDAO dao=new MemberDAO();
			int cnt=dao.memberDelete(num);
			if(cnt>0) {
				// 성공->다시 리스트페이로...
				response.sendRedirect("/m12/memberList.do");
			}else {
				throw new ServletException("error");
			}
	  }else if(command.equals("/memberContent.do")) {
		    // 파라메터수집
			int num=Integer.parseInt(request.getParameter("num"));
			MemberDAO dao=new MemberDAO();
			MemberVO vo=dao.memberContent(num);
			//객체바인딩
			request.setAttribute("vo", vo);
			RequestDispatcher rd=request.getRequestDispatcher("member/memberContent.jsp");
			rd.forward(request, response);

	  }else if(command.equals("/memberUpdate.do")) {
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
	        	response.sendRedirect("/m12/memberList.do");
	        }else {
	        	throw new ServletException("error");
	        }	
	  }else if(command.equals("/memberInsert.do")) {
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
	        	response.sendRedirect("/m12/memberList.do");
	        }else {
	        	throw new ServletException("error");
	        }
	  }else if(command.equals("/memberInsertForm.do")) {
		  //회원가입페이지로 이동(forward, redirect)
		  RequestDispatcher rd=request.getRequestDispatcher("member/memberRegister.html");
		  rd.forward(request, response);
	  }
	}
}
