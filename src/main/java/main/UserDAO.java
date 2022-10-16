
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;

	public UserDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/mariadb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserVO findUser(String _id) {
		UserVO userInfo = null;
		try {
			conn=dataFactory.getConnection();
			String query="select * from t_member where id=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(query);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			
			String id=rs.getString("id");
			String password=rs.getString("password");
			String nickname=rs.getString("nickname");
			String phone_number=rs.getString("phone_number");
			
			userInfo=new UserVO(id,password,nickname,phone_number);
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
	
	
	public void addMember(UserVO u) {
		try {
			conn = dataFactory.getConnection();
			String id = u.getId();
			String password = u.getPwd();
			String nickname = u.getNickname();
			String number = u.getPhone_number();
			String query = "INSERT INTO t_member(id, password, nickname, number)" + " VALUES(?, ? ,? ,?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, nickname);
			pstmt.setString(4, number);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
