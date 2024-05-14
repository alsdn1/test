package jmybatis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	
	// DAO
//	 �����Ͱ� �ִ� ����ҷ� �����ϴ� ������ ��ü
//	 ���� DB�� �����ؼ� �����͸� ����,����,��ȸ ��� ����
//	 �� �� �ִ� ����� �����Ѵ�. ( CRUD�� ������ )
//	 �����͸� ���� DB�� ������. ( MVC���Ͽ��� Model ���� )
	
	Connection conn = null;
	// �������� �ؼ����ִ� ����
	PreparedStatement pt = null;
	
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8 & serverTimezone=UTC";
	String dbId = "root";
	String dbPw = "1234";
	
//	 insert�� ����
//	 user ���̺� �����͸� ����
	
	public void insertUser(UserDTO userDTO) {
		try {
			// JDBC ����̹� �ε� 
			Class.forName(dbDriver);
			
			// DB �����ϱ�
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			// SQL�� , ? �� ���� ������ ������ ������
			String insertSQL = "insert into user values(?,?,?,?,?,?)";
			
			// conn SQL�� ����! DB�� �����Ѵٴ� ��
			pt  = conn.prepareStatement(insertSQL);
			
			// SQL �Է� �� ����
			pt.setString(1, userDTO.getUser_id());
			pt.setString(2, userDTO.getUser_pw());
			pt.setString(3, userDTO.getName());
			pt.setString(4, userDTO.getPhone());
			pt.setString(5, userDTO.getGrade());
			pt.setInt(6, userDTO.getAge());
			
			pt.executeUpdate();
			
			pt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectUser() {
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		try {
			
			Class.forName(dbDriver);
			
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String selectSQL = "select * from user";
			
			pt = conn.prepareStatement(selectSQL);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				UserDTO dto = new UserDTO(rs.getString("user_id"), rs.getString("user_pw"),
						rs.getString("name"),rs.getString("phone"),rs.getString("grade"),rs.getInt("age"));
			
				users.add(dto);
			}
			for(UserDTO oneuser : users) {
				System.out.println(oneuser);
			}
			
			pt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateUser(String user_id) {
		
		try {
			Class.forName(dbDriver);
			
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String updateSQL = "update test set where user_id=?";
			
			pt = conn.prepareStatement(updateSQL);
			
			pt.setString(1, user_id);			
			
			pt.executeUpdate();
			
			pt.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteUser(String id) {
		
		try {
			
			Class.forName(dbDriver);
			
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String DeleteSQL = "delete test set where user_id=?";
			
			pt = conn.prepareStatement(DeleteSQL);
			
			pt.setString(1, id);
			
			pt.executeUpdate();
			
			pt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}//��
