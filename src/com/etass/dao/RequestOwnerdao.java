package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class RequestOwnerdao extends DbCon{

	public ArrayList<Profilebean> requestedowners() {
		Connection con=null;
		con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select USER_ID,USERNAME,MAIL,MOBILE,GENDER,ADDRESS from USERDETAILS where ROLE=? and STATUS=?");
			ps.setString(1, "DataOwner");
			ps.setString(2, "Pending");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Profilebean pb=new Profilebean();
				String userid=rs.getString(1);
				String username=rs.getString(2);
				String mail=rs.getString(3);
				String mobile=rs.getString(4);
				String gender=rs.getString(5);
				String address=rs.getString(6);
				pb.setLoginid(userid);
				pb.setUsername(username);
				pb.setEmail(mail);
				pb.setMobileno(mobile);
				pb.setGender(gender);
				pb.setAddress(address);
				
				list.add(pb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Profilebean> viewowners() {
		Connection con=null;
		con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select USER_ID,USERNAME,MAIL,MOBILE,GENDER,ADDRESS from USERDETAILS where ROLE=? and STATUS=?");
			ps.setString(1, "DataOwner");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Profilebean pb=new Profilebean();
				String userid=rs.getString(1);
				String username=rs.getString(2);
				String mail=rs.getString(3);
				String mobile=rs.getString(4);
				String gender=rs.getString(5);
				String address=rs.getString(6);
				pb.setLoginid(userid);
				pb.setUsername(username);
				pb.setEmail(mail);
				pb.setMobileno(mobile);
				pb.setGender(gender);
				pb.setAddress(address);
				
				list.add(pb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public int requestaccept(String loginid) {
		Connection con=null;
		int i=0;
		con=getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("update USERDETAILS set status=? where USER_ID=?");
			
			ps.setString(1, "Active");
			ps.setString(2, loginid);
			
			 i=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
		
		
	}

	public ArrayList<Profilebean> getdata(String userid) {
		Connection con=null;
		con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select USER_ID,USERNAME,MAIL,MOBILE,GENDER,ADDRESS from USERDETAILS where user_id=?");
			ps.setString(1, userid);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Profilebean pb=new Profilebean();
				String userid1=rs.getString(1);
				String username=rs.getString(2);
				String mail=rs.getString(3);
				String mobile=rs.getString(4);
				String gender=rs.getString(5);
				String address=rs.getString(6);
				pb.setLoginid(userid1);
				pb.setUsername(username);
				pb.setEmail(mail);
				pb.setMobileno(mobile);
				pb.setAddress(address);
				
				list.add(pb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

		

	
	
	
}
