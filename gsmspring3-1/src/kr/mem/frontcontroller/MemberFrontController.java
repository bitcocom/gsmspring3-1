package kr.mem.frontcontroller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.controller.Controller;
import kr.mem.controller.MemberContentController;
import kr.mem.controller.MemberDeleteController;
import kr.mem.controller.MemberInsertController;
import kr.mem.controller.MemberListController;
import kr.mem.controller.MemberRegisterController;
import kr.mem.controller.MemberUpdateController;
import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
@WebServlet("*.do")
// MVC->MVC변형(FrontController등장)
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");
	  String reqPath=request.getRequestURI();
	  String ctx=request.getContextPath();		  
	  String command=reqPath.substring(ctx.length());
	  System.out.println(command);
	  Controller controller=null;
	  String view=null;
	  HandlerMapping mapping=new HandlerMapping();
	  controller=mapping.getController(command);
	  // 분기작업->forward or redirect
	  view=controller.requestHandler(request, response);
	  // member/memberContent.jsp, redirect:/m12/memberList.do
	  if(view!=null) {
		if(view.indexOf("redirect:")!=-1) {  
	      response.sendRedirect(view.split(":")[1]); // redirect:/m12/memberList.do
		}else {
	      RequestDispatcher rd=request.getRequestDispatcher(view);
	      rd.forward(request, response);
		}//_if
	  }//_if
	}
}
