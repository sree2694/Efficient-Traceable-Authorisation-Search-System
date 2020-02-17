package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class DataUserLogindao extends DbCon {

	public ArrayList<Profilebean> datauserlogin(Profilebean pb) {
		Connection con=null;
		//int i=0;
		Profilebean pb1=null;
		
		
		
		String uid=pb.getLoginid();
		String password=pb.getPassword();
		
		con=getConnection();
	/*System.out.println("*******connection*********"+con);*/
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select role,username,STATUS from USERDETAILS where User_id=? and password=?");
			ps.setString(1, uid);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				pb1=new Profilebean();
				String role=rs.getString(1);
				String username= rs.getString(2);
				String status=rs.getString(3);
	  
				 
				
				pb1.setRole(role);
				pb1.setUsername(username);
				pb1.setStatus(status);
				list.add(pb1);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
		
		
	}

}
