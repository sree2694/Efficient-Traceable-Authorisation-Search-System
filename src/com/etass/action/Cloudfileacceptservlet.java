package com.etass.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etass.dao.Cloudfileacceptdao;

public class Cloudfileacceptservlet extends HttpServlet {

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
		
		int fileid=Integer.parseInt(request.getParameter("id"));
		
		
		Cloudfileacceptdao cad=new Cloudfileacceptdao();
		try{
		int i=cad.accept(fileid);
		if(i!=0){
			RequestDispatcher rd=request.getRequestDispatcher("CloudRequestfileServlet?status=Success");
			rd.include(request, response);
			
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("CloudRequestfileServlet?status=Faild");
			rd.include(request, response);
			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
