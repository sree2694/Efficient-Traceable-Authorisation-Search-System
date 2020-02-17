package com.etass.dao;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class CloudRequestfiledao extends DbCon{

	public ArrayList<Profilebean> requestedfiles() {
		Connection con=null;
		con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select file_id,USERID,NAME,MAILID,MOBILE,ADDRESS,FILE_NAME from FILE_TABLE where STATUS=?");
			ps.setString(1, "Pending");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Profilebean pb=new Profilebean();
				int fileid=rs.getInt(1);
				String userid=rs.getString(2);
				String username=rs.getString(3);
				String mail=rs.getString(4);
				String mobile=rs.getString(5);
				String address=rs.getString(6);
				String filename=rs.getString(7);
				pb.setFileid(fileid);
				pb.setLoginid(userid);
				pb.setUsername(username);
				pb.setEmail(mail);
				pb.setMobileno(mobile);
				pb.setAddress(address);
				pb.setFilename(filename);
				
				list.add(pb);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
