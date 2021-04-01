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
	   String password="12345";
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
   //회원가입기능
   public int memberInsert(MemberVO vo) {
	  getConnect(); //                                                    ?(파라메터) 
	  String SQL="insert into member(id,pass,name,age,phone,email) values(?,?,?,?,?,?)";
	  int cnt=0;
	  try {
		  ps=conn.prepareStatement(SQL);
		  ps.setString(1, vo.getId());
		  ps.setString(2, vo.getPass());
		  ps.setString(3, vo.getName());
		  ps.setInt(4, vo.getAge());
		  ps.setString(5, vo.getPhone());
		  ps.setString(6, vo.getEmail());
		  cnt=ps.executeUpdate(); //실행		  
		} catch (Exception e) {
		e.printStackTrace();
	  }
	  return cnt;
   }
   // 선택한 회원을 삭제하는 동작(memberDelete)
   public int memberDelete(int num) {
	   getConnect();
	   String SQL="delete from member where num=?";
	   int cnt=0;
	   try {
		ps=conn.prepareStatement(SQL);
		ps.setInt(1, num);
		cnt=ps.executeUpdate();
	   } catch (Exception e) {
		  e.printStackTrace();
	   }
	   return cnt;
   }
   
}









