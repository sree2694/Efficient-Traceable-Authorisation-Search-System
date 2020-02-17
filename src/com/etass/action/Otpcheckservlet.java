package com.etass.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etass.dao.FileDownloaddao;
import com.etass.dao.Otpcheckdao;
import com.etass.dto.Profilebean;

public class Otpcheckservlet extends HttpServlet {
	int count=0;

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
		try{
		HttpSession session=request.getSession();
		String loginid=(String) session.getAttribute("uname");
		int fileid=Integer.parseInt(request.getParameter("fileid"));
		String ownername=request.getParameter("ownername");
		String filename=request.getParameter("filename");
		long otp=Long.parseLong(request.getParameter("otp"));
		
		Profilebean pb=new Profilebean();
		pb.setLoginid(loginid);
		pb.setFileid(fileid);
		pb.setOwnername(ownername);
		pb.setFilename(filename);
		pb.setSecretekey(otp);
		Otpcheckdao ocd=new Otpcheckdao();

		
		int i=ocd.otpcheck(pb);
		

		if(i==0){
			
			FileDownloaddao fdd=new FileDownloaddao();
			ArrayList<Profilebean> list=fdd.filedownload(pb);
			session.setAttribute("list",list);			
			RequestDispatcher rd= request.getRequestDispatcher("Filedownload.jsp");
			rd.include(request,response);
		}
		else{
			count++;
			if(count==1){
			
			RequestDispatcher rd= request.getRequestDispatcher("DownloadfileServlet?status=Invalid otp");
			rd.include(request, response);
			
			}
			if(count==2){
				
				int k=ocd.malicious(pb);
				RequestDispatcher rd= request.getRequestDispatcher("Logout.jsp?status=Your Account has been closed");
				rd.include(request, response);
				
			}
		}
		}
		catch (Exception e) {
			RequestDispatcher rd= request.getRequestDispatcher("DownloadfileServlet?status=Invalid otp");
			rd.include(request, response);
			
		}
	}

}
