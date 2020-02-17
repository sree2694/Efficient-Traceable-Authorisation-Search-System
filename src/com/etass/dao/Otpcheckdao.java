package com.etass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etass.db.DbCon;
import com.etass.dto.Profilebean;


public class Otpcheckdao extends DbCon {

	int i=0;
	int count=0;
	
	public int otpcheck(Profilebean pb) {
		
		
		
		Connection con=null;
		con=getConnection();
		int fileid=pb.getFileid();
		String ownername=pb.getOwnername();
		String filename=pb.getFilename();
		String loginid=pb.getLoginid();
		long otp=pb.getSecretekey();
		try
		{
		
		PreparedStatement ps=con.prepareStatement("select SECRETE_KEY from REQUEST_TABLE where FILE_ID='"+fileid+"' and OWNERNAME='"+ownername+"'  and FILENAME='"+filename+"' and USERID='"+loginid+"'");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			long otp1=rs.getLong(1);
			if(otp1==otp){
								
				
					return i;
				
				
								
			}else{
				
				i++;
					
				
		}
			return i;
		}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return i;
		
	
	}

	public int malicious(Profilebean pb) throws SQLException {
		
				
		Connection con=null;
		con=getConnection();
		int fileid=pb.getFileid();
		String ownername=pb.getOwnername();
		String filename=pb.getFilename();
		String loginid=pb.getLoginid();
		long otp=pb.getSecretekey();
		
				PreparedStatement	ps4= con.prepareStatement("update USERDETAILS set STATUS=? where USER_ID=? ");
				ps4.setString(1, "Malicious");
				ps4.setString(2, loginid);
				 int k=ps4.executeUpdate();
				 System.out.println("k******"+k);
				return k;
		} 
		
	


}