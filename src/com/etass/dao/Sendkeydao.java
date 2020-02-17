package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class Sendkeydao extends DbCon{

	public int sendkey(Profilebean pb) {
		
		Connection con=null;
		int i=0;
		con=getConnection();
		int fileid=pb.getFileid();
		String ownername=pb.getOwnername();
		String filename=pb.getFilename();
		String username=pb.getUsername();
		long key=pb.getSecretekey();
		System.out.println("id-->"+fileid);
		System.out.println("ownername-->"+ownername);
		System.out.println("filename-->"+filename);
		System.out.println("username-->"+username);
		System.out.println("key-->"+key);
		
		
		try{
			PreparedStatement ps=con.prepareStatement("update REQUEST_TABLE set status=?,SECRETE_KEY=? where FILE_ID=? and OWNERNAME=? and FILENAME=? and USER_NAME=?");
			ps.setString(1,"Active");
			ps.setLong(2, key);
			ps.setInt(3, fileid);
			ps.setString(4, ownername);			
			ps.setString(5, filename);
			ps.setString(6, username);
			i=ps.executeUpdate();
		}
		catch (Exception e) {
e.printStackTrace();
		}
		return i;
	}
	
	

}
