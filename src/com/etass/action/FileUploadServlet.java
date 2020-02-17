package com.etass.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etass.dao.FileUploaddao;
import com.etass.db.CryptoUtils;
import com.etass.dto.Profilebean;


public class FileUploadServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String loginid=request.getParameter("uid");
		String username=request.getParameter("uname");
		String mail=request.getParameter("mid");
		String mobile=request.getParameter("mno");
		String address=request.getParameter("add");
		String file=request.getParameter("file");
		
		File f=new File(request.getParameter("file"));
		String filename=f.getName();
		
		String status="Pending";
		String key="1234567890123456";
		
		File file1=new File("F:/"+filename);
		
		System.out.println("before");
		CryptoUtils.encrypt(key, f, file1);
		System.out.println("encryption completed");
		
		Profilebean pb=new Profilebean();
		pb.setLoginid(loginid);
		pb.setUsername(username);
		pb.setEmail(mail);
		pb.setMobileno(mobile);
		pb.setAddress(address);
		pb.setFile(file);
		pb.setFile1(f);
		pb.setStatus(status);
		pb.setFilename(filename);
		FileUploaddao fd=new FileUploaddao();
		
		try {
			int i=fd.upload(pb);
			if(i!=0){
				RequestDispatcher rd=request.getRequestDispatcher("UploadFile.jsp?status=Data Uploaded successfully");
				rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("UploadFile.jsp?status=Data NOt Uploaded");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			RequestDispatcher rd=request.getRequestDispatcher("UploadFile.jsp?status=Some Internal Problem Occured");
			rd.include(request, response);
			
		}
	}

}
