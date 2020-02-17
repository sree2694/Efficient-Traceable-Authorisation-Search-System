package com.etass.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etass.dao.Requestsendtokgcdao;
import com.etass.dto.Profilebean;

public class RequestsendtokgcServlet extends HttpServlet {

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
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		String userid=(String) session.getAttribute("uname");
		int fileid=Integer.parseInt(request.getParameter("id"));
		String ownername=request.getParameter("username");
		String mail=request.getParameter("mail");
		String mobile=request.getParameter("mobile");
		String filename=request.getParameter("filename");
		
	Profilebean pb=new Profilebean();
	pb.setFileid(fileid);
	pb.setUsername(username);
	pb.setEmail(mail);
	pb.setMobileno(mobile);
	pb.setFilename(filename);
	pb.setOwnername(ownername);
	pb.setLoginid(userid);
	
	Requestsendtokgcdao rsk=new Requestsendtokgcdao();
	int i;
	try {
		i = rsk.requesttokgc(pb);
	
	if(i!=0){
	RequestDispatcher rd=request.getRequestDispatcher("Filesearchingservlet?status=Request Send Successfully to Kgc ");
	rd.include(request, response);
	
	}
	else {
		RequestDispatcher rd=request.getRequestDispatcher("Filesearchingservlet?atus=Request Not Send ");
		rd.include(request, response);
		
		
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
}
