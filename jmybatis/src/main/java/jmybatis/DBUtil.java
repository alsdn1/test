package jmybatis;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	SqlSessionFactory sqlSessionFactory;
	
	public void init() {
	try {
		String resource = "jmybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);
	}catch(Exception e) {
		System.out.println("MyBatis 설정 파일 가져오기 실패 ㅜㅜ");
		
		e.printStackTrace();
	}
	}
	// select
	public ArrayList<UserDTO> getUser() {
//		  SQL문 처리
		  SqlSession session = sqlSessionFactory.openSession(); 
		  UserMapper mapper = session.getMapper(UserMapper.class);
		  ArrayList<UserDTO> userlist = mapper.getUser();
		  
		  return userlist;
		  
	}
	
	// insert
	
	public void insertUser(String user_id, String user_pw, String name, String phone, String grade, int age) {
		
		SqlSession session = sqlSessionFactory.openSession(); 
		  UserMapper mapper = session.getMapper(UserMapper.class);
		  UserDTO userDTO = new UserDTO(user_id,user_pw,name,phone,grade,age);
		  mapper.insertUser(userDTO);
		  session.commit(); // insert,update,delete 에만 해당 (필수)
	}
	
	// update
	
	public void updateUser(String name,String user_id) {
		
		SqlSession session = sqlSessionFactory.openSession(); 
		  UserMapper mapper = session.getMapper(UserMapper.class);
		  mapper.updateUser(name,user_id);
		  session.commit();
	}
	
	// delete
	
	public void deleteUser(String user_id) {
		
		SqlSession session = sqlSessionFactory.openSession(); 
		  UserMapper mapper = session.getMapper(UserMapper.class);
		  mapper.deleteUser(user_id);
		  session.commit();
	}
	
}
