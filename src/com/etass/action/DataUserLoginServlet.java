package com.etass.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etass.dao.DataUserLogindao;
import com.etass.dao.LoginDao;
import com.etass.dto.Profilebean;

public class DataUserLoginServlet extends HttpServlet {

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
		
		String uname=request.getParameter("uid");
		String password=request.getParameter("pass");
		String role=null;
		String username=null;
		String status=null;
		
		Profilebean pb=new Profilebean();
		pb.setLoginid(uname);
		pb.setPassword(password);
		

		DataUserLogindao ld=new DataUserLogindao();
		try{
		
			ArrayList<Profilebean> list=ld.datauserlogin(pb);
		for(Profilebean p:list){
			 role=p.getRole();
			 username=p.getUsername();
			 status=p.getStatus();
			 System.out.println("role****"+role);
			 System.out.println("name****"+username);
			 System.out.println("status****"+status);
		}
		if("DataUser".equals(role) && status.equals("Active")){
			
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("username", username);
			RequestDispatcher rd=request.getRequestDispatcher("DataUserHome.jsp");
			rd.include(request, response);
			
		}
		else if("DataUser".equals(role)&& status.equals("Pending")){
			
			
			RequestDispatcher rd=request.getRequestDispatcher("DataUserlogin.jsp?status=Your Request is in Pending");
			rd.include(request, response);
			
		}
		
		else {
			RequestDispatcher rd=request.getRequestDispatcher("DataUserlogin.jsp?status=Invalid UserName and Password");
			rd.include(request, response);
			
		}
		}
		catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("DataUserlogin.jsp?status=Some Internal Problem");
			rd.include(request, response);

			
		}
		

	}

}
