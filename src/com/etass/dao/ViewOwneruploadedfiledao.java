package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class ViewOwneruploadedfiledao extends DbCon {

	public ArrayList<Profilebean> viewfiles(String loginid) {
		
		Connection con=null;
		con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try{
			PreparedStatement ps=con.prepareStatement("select FILE_ID,FILE_NAME,STATUS from FILE_TABLE where USERID=?");
			ps.setString(1, loginid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Profilebean pb=new Profilebean();
				int fileid=rs.getInt(1);
				String filename=rs.getString(2);
				String status=rs.getString(3);
				pb.setFileid(fileid);
				pb.setFilename(filename);
				pb.setStatus(status);
				list.add(pb);
			}
		}
		catch (Exception e) {

		}
		return list;
	}

}
