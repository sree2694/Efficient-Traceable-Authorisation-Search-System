package com.etass.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;

public class FileUploaddao extends DbCon{

	public int upload(Profilebean pb) throws SQLException {
		String loginid=pb.getLoginid();
		String username=pb.getUsername();
		String mail=pb.getEmail();
		String mobile=pb.getMobileno();
		String address=pb.getAddress();
		String file=pb.getFile();
		String status=pb.getStatus();
		String filename=pb.getFilename();
		File f=pb.getFile1();
		
		int i=0;
		int fileid=100;
		Connection con=null;
		con=getConnection();
		
		
		PreparedStatement pst=con.prepareStatement("select max(FILE_ID) from FILE_TABLE");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			fileid = rs.getInt(1);
			fileid=fileid+1;
		}

		try{
			PreparedStatement ps=con.prepareStatement("insert into FILE_TABLE(FILE_ID,USERID,NAME,MAILID,MOBILE,ADDRESS,FILES,STATUS,FILE_NAME) values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, fileid);
			ps.setString(2,loginid);
			ps.setString(3, username);
			ps.setString(4, mail);
			ps.setString(5, mobile);
			ps.setString(6, address);
			FileInputStream fis=new FileInputStream(f);
			ps.setBinaryStream(7, fis,fis.available());
			ps.setString(8, status);
			ps.setString(9, filename);
			 i=ps.executeUpdate();
			 System.out.println("i*********"+i);
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		return i;
	}
}
