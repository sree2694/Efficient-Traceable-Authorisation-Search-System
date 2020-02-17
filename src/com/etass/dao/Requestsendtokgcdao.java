package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class Requestsendtokgcdao extends DbCon{

	public int requesttokgc(Profilebean pb) throws SQLException {
		
		
		int fileid=pb.getFileid();
		String username=pb.getUsername();
		String mail=pb.getEmail();
		String mobile=pb.getMobileno();
		String filename=pb.getFilename();
		String ownername=pb.getOwnername();
		String userid=pb.getLoginid();
		
		int i=0;
		int count=0;
		Connection con=null;
		con=getConnection();
PreparedStatement ps1=con.prepareStatement("select count(*) from REQUEST_TABLE  where FILE_ID=? and OWNERNAME=? and MAIL=? and MOBILE=? and FILENAME=? and USER_NAME=?");
		
		ps1.setInt(1, fileid);
		ps1.setString(2, ownername);
		ps1.setString(3, mail);
		ps1.setString(4, mobile);
		ps1.setString(5, filename);
		ps1.setString(6, username);
		
	
		ResultSet rs2=ps1.executeQuery();
		if(rs2.next()){
			count=rs2.getInt(1);
	if(rs2.getInt(1)==1){
		PreparedStatement ps2=con.prepareStatement("update REQUEST_TABLE set STATUS=?,SECRETE_KEY=? where FILE_ID=? and USER_NAME=?");
		ps2.setString(1, "Pending");
		ps2.setInt(2, 0);
		 ps2.setInt(3, fileid);
		 ps2.setString(4, username);
		 
        i=ps2.executeUpdate();
	}
		
		else{
		try{
		PreparedStatement ps=con.prepareStatement("insert into REQUEST_TABLE(FILE_ID,OWNERNAME,MAIL,MOBILE,FILENAME,STATUS,SECRETE_KEY,USER_NAME,USERID) values(?,?,?,?,?,?,?,?,?)");
          ps.setInt(1, fileid);
          ps.setString(2, ownername);
          ps.setString(3, mail);
          ps.setString(4, mobile);
          ps.setString(5, filename);
          ps.setString(6, "Pending");
          ps.setInt(7, 0);
          ps.setString(8, username);
          ps.setString(9, userid);
         i= ps.executeUpdate();
		
		}
		catch (Exception e) {

		}
		}
		}
return i;
	}
	

}
