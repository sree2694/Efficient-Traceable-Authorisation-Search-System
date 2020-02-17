package com.etass.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etass.dao.UnrevokeRequestAcceptdao;

public class UnrevokeRequestAcceptServlet extends HttpServlet {

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
		String loginid=request.getParameter("id");
		
		UnrevokeRequestAcceptdao urra=new UnrevokeRequestAcceptdao();
		try{
		int i=urra.unrevokers(loginid);
	if(i!=0){
		RequestDispatcher rd=request.getRequestDispatcher("Unrevokeusersservlet?status=User Activated Successfully");
		rd.include(request, response);
		
	}
	else {
		RequestDispatcher rd=request.getRequestDispatcher("Unrevokeusersservlet?status=User is Not Activated");
		rd.include(request, response);
	}
		
		}
		catch (Exception e) {

			RequestDispatcher rd=request.getRequestDispatcher("Unrevokeusersservlet?status=Some Internal Problem Occured Plz Try After Some Time");
			rd.include(request, response);
		}
	
	
	
	
	
	}

}
