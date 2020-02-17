package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class Downloadfiledao  extends DbCon{

	public ArrayList<Profilebean> download(String loginid) {
		
		Connection con=null;
		con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try{
			PreparedStatement ps=con.prepareStatement("select FILE_ID,OWNERNAME,FILENAME from REQUEST_TABLE  where USERID=? and STATUS=?");
			ps.setString(1, loginid);
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Profilebean pb=new Profilebean();
				int fileid=rs.getInt(1);
				String ownername=rs.getString(2);
				String filename=rs.getString(3);
				
				pb.setFileid(fileid);
				pb.setOwnername(ownername);
				pb.setFilename(filename);
				
				list.add(pb);
			}
			
		}
		catch (Exception e) {

		}
		return list;
	}

}
