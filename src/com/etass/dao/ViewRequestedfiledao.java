package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class ViewRequestedfiledao extends DbCon {

	public ArrayList<Profilebean> viewrequestedfiles() {
	
		
		
		Connection con=null;
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		con=getConnection();
		try{
			PreparedStatement ps=con.prepareStatement("select FILE_ID,OWNERNAME,USER_NAME,MAIL,MOBILE,FILENAME from REQUEST_TABLE where STATUS=?");
			ps.setString(1, "Pending");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Profilebean pb=new Profilebean();
				int fileid=rs.getInt(1);
				String ownername=rs.getString(2);
				String username=rs.getString(3);
				String mail=rs.getString(4);
				String mobile=rs.getString(5);
				String filename=rs.getString(6);
				
				pb.setFileid(fileid);
				pb.setOwnername(ownername);
				pb.setUsername(username);
				pb.setEmail(mail);
				pb.setMobileno(mobile);
				pb.setFilename(filename);
				list.add(pb);
			}
		}
		
		catch (Exception e) {
				e.printStackTrace();
		}
		
		return list;
	}

}
