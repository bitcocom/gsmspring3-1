package kr.mem.model;
// JDBC->myBatis->JPA
// mysql->jdbc->Driver class(jar)
import java.sql.*;
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
   public void getList() {
	   getConnect();
	   String SQL="select * from member";
	   // SQL문장전송객체생성
	   try {
		  ps=conn.prepareStatement(SQL);
		  
	    } catch (Exception e) {
   		 e.printStackTrace();
	   }   
	   
   }
}
