package com.etass.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;





public class RegistrationDao extends DbCon{

public int register(Profilebean pb) {
		
		int i=0;
		Connection con=null;
		String loginid=pb.getLoginid();
		String password=pb.getPassword();
		String username=pb.getUsername();
		String email=pb.getEmail();
		String mobile=pb.getMobileno();
		String gender=pb.getGender();
		String address=pb.getAddress();
		String role=pb.getRole();
		 
		
		con=getConnection();
		
		System.out.println("connection post***************"+con);
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into USERDETAILS(user_id,PASSWORD,ROLE,USERNAME,MAIL,MOBILE,GENDER,ADDRESS,STATUS) values(?,?,?,?,?,?,?,?,?)");
			
		pstmt.setString(1, loginid);
		pstmt.setString(2, password);
		pstmt.setString(3, role);
		pstmt.setString(4, username);
		pstmt.setString(5, email);
		pstmt.setString(6, mobile);
		pstmt.setString(7, gender);
		pstmt.setString(8, address);
		pstmt.setString(9, "Pending");
		
		 i=pstmt.executeUpdate();
		
		System.out.println(i+"Record is Inserted successfully");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return i;
	}
	
	

}
