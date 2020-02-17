package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.util.Login;

import com.etass.db.DbCon;

public class Cloudfileacceptdao extends DbCon{

	public int accept(int fileid) {
		
		Connection con=null;
		int i=0;
		con=getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update FILE_TABLE set STATUS=? where FILE_ID=? ");
			ps.setString(1, "Active");
			ps.setInt(2, fileid);
			
			i=ps.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
			}

}
