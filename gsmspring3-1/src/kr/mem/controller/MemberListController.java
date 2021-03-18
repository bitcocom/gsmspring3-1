package kr.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                    throws ServletException, IOException {
		// 회원전체 리스트 가져오기(Model)
		MemberDAO dao=new MemberDAO();
		List<MemberVO> list=dao.getList();
		// 클라이언트에게 회원리스트를 응답해준다(HTML)
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>num</td>");
		out.println("<td>id</td>");
		out.println("<td>pass</td>");
		out.println("<td>name</td>");
		out.println("<td>age</td>");
		out.println("<td>email</td>");
		out.println("<td>phone</td>");
		out.println("</tr>");
		for(MemberVO vo : list) {
			out.println("<tr>");
			out.println("<td>"+vo.getNum()+"</td>");
			out.println("<td>"+vo.getId()+"</td>");
			out.println("<td>"+vo.getPass()+"</td>");
			out.println("<td>"+vo.getName()+"</td>");
			out.println("<td>"+vo.getAge()+"</td>");
			out.println("<td>"+vo.getEmail()+"</td>");
			out.println("<td>"+vo.getPhone()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
