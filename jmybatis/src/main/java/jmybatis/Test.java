package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		DBUtil my = new DBUtil();
		
		my.init();
		
		ArrayList<UserDTO> list = my.getUser();
		
		Scanner s = new Scanner(System.in);
		 while (true) {
	         System.out.println("[1]정보추가 [2]삭제 [3]수정 [4]조회 [5]검색");
	         int choice = s.nextInt();
	         s.nextLine();
	         if (choice == 1) {
	            System.out.println("정보추가");

	            // 사용자로부터 입력을 받기

	            System.out.print("아이디 입력 : ");
	            String user_id = s.nextLine();
	            System.out.print("비밀번호 입력 : ");
	            String user_pw = s.nextLine();
	            System.out.print("이름 입력 : ");
	            String name = s.nextLine();
	            System.out.print("전화번호 입력 : (예시:010-1111-1111) : ");
	            String phone = s.nextLine();
	            System.out.print("등급 입력 : ");
	            String grade = s.nextLine();
	            System.out.print("나이 입력 : ");
	            int age = s.nextInt();

	            my.insertUser(user_id,user_pw,name,phone,grade,age);

	           
	         } // insert끝
	         
	         if (choice == 2) {
	            System.out.println("삭제");
	            System.out.print("아이디 입력 : ");
	            String user_id = s.nextLine();
	            my.deleteUser(user_id);
	         } // delete 끝

	         if (choice == 3) {
	            System.out.println("수정");

	            System.out.print("바꿀 이름 : ");
	            String name = s.nextLine();
	            System.out.print("수정 할 아이디 : ");
	            String user_id =s.nextLine();

	            my.updateUser(name, user_id);
	         } // update 끝
	         if (choice == 4) {
	            System.out.println("조회");
	            UserDAO dao = new UserDAO();
               dao.selectUser();
	         } // all select 끝
//	         if (choice == 5) {
//	            System.out.println("검색");
//	            System.out.println("검색합니다");
//	            System.out.print("검색할 아이디 : ");
//	            String user_id = s.nextLine();
//	         }

	      }
		
		
	}

}
