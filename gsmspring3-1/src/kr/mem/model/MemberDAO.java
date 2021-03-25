package kr.mem.model;
// JDBC->myBatis->JPA
// mysql->jdbc->Driver class(jar)
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MemberDAO {
   private Connection conn;
   private PreparedStatement ps;
   private ResultSet rs; // select SQL
   // 연결객체
   public void getConnect() {
	   String URL="jdbc:mysql://localhost:3306/mysql"; //데이터베이스접속 URL
	   String user="root";
	   String password="admin12345";
       // Driver class를 메모리에 로딩(동적로딩)
	   try {
		  Class.forName("com.mysql.jdbc.Driver");
		  conn=DriverManager.getConnection(URL, user, password);
	   } catch (Exception e) {
		 e.printStackTrace();
	}	
   }
   // 회원전체 리스트 가져오기
   public List<MemberVO> getList() {
	   getConnect();
	   String SQL="select * from member";
	   List<MemberVO> list=new ArrayList<MemberVO>();
	   // SQL문장전송객체생성
	   try {
		  ps=conn.prepareStatement(SQL);
		  rs=ps.executeQuery();
		  while(rs.next()) {
			 int num=rs.getInt("num");
			 String id=rs.getString("id");
			 String pass=rs.getString("pass");
			 String name=rs.getString("name");
			 int age=rs.getInt("age");
			 String email=rs.getString("email");
			 String phone=rs.getString("phone");
			 // 묶고(VO)->담고(ArrayList)
			 MemberVO vo=new MemberVO();
			 vo.setNum(num);
			 vo.setId(id);
			 vo.setPass(pass);
			 vo.setName(name);
			 vo.setAge(age);
			 vo.setEmail(email);
			 vo.setPhone(phone);
			 list.add(vo);
		  }
	    } catch (Exception e) {
   		 e.printStackTrace();
	   } 
	   System.out.println(list.toString());
	   return list;
   }
}
