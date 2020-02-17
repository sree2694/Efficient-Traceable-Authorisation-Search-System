package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.etass.db.DbCon;

public class UnrevokeRequestAcceptdao extends DbCon{

	public int unrevokers(String loginid) {
		
		int i=0;
		Connection con=null;
		con=getConnection();
		try{
			PreparedStatement ps=con.prepareStatement("update USERDETAILS set status=? where USER_ID=?");
			
			ps.setString(1, "Active");
			ps.setString(2, loginid);
			 i=ps.executeUpdate();
			 
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return i;
		
	}

	
	
	
}
