package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class Filesearchingdao extends DbCon {

	public ArrayList<Profilebean> filesearch() {
		Connection con=null;
		con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try{
			PreparedStatement ps=con.prepareStatement("select FILE_ID,NAME,MAILID,MOBILE,FILE_NAME from FILE_TABLE where STATUS=?");
			ps.setString(1, "Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Profilebean pb=new Profilebean();
				int fileid=rs.getInt(1);
				String ownername=rs.getString(2);
				String mail=rs.getString(3);
				String mobile=rs.getString(4);
				String filename=rs.getString(5);
				
				pb.setFileid(fileid);
				pb.setUsername(ownername);
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
