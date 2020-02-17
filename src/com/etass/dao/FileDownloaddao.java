package com.etass.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etass.db.CryptoUtils;
import com.etass.db.DbCon;
import com.etass.dto.Profilebean;


public class FileDownloaddao extends DbCon{

	public ArrayList<Profilebean> filedownload(Profilebean pb) throws FileNotFoundException {
		
		String loginid=pb.getLoginid();
		int fileid=pb.getFileid();
		String ownername=pb.getOwnername();
		String filename=pb.getFilename();
		
		Connection con=null;
		con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select FILE_ID,NAME,FILE_NAME,FILES from FILE_TABLE where FILE_ID=? and FILE_NAME=? and NAME=?");
			ps.setInt(1, fileid);
			ps.setString(3, ownername);
			ps.setString(2, filename);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Profilebean pb1=new Profilebean();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String fname=rs.getString(3);
				Blob b=rs.getBlob(4);
				byte[] brr=b.getBytes(1, (int) b.length());
				FileOutputStream fos=new FileOutputStream("F:/"+fname);
				fos.write(brr);
				pb1.setFileid(fileid);
				pb1.setOwnername(name);
				pb1.setFilename(fname);
				pb1.setFile(""+fname);
				
				File file=new File("F:/"+fname);
				String key="1234567890123456";
				
				File file2=new File("F:/"+fname);
				
				
				
				
				System.out.println("before");
				CryptoUtils.decrypt(key, file, file2);
				System.out.println("decrypted successfully");
				
							
				list.add(pb1);
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

}
