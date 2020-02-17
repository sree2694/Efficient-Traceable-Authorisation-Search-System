package com.etass.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etass.dao.Sendkeydao;
import com.etass.db.EMailer;
import com.etass.dto.Profilebean;

public class SendkeyServlet extends HttpServlet {

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
		//String email=(String) session.getAttribute("email");
		String email="sreekanth.nilu@gmail.com";
		 Random rand = new Random();
		 long key = rand.nextInt(10000000);
		int fileid=Integer.parseInt(request.getParameter("id"));
		String ownername=request.getParameter("ownername");
		String filename=request.getParameter("filename");
		String username=request.getParameter("username");
		
		
		String details="<strong>Fileid:</strong>"+fileid+"\n<br/><strong>Owner Name:</strong>"+ownername+"\n <br/><strong>filename:</strong>"+filename+"\n<br/> <strong>secrete key:</strong>"+key+"<strong>Dont Share Secrete Keys With Any One </strong>";
		
		
		System.out.println("EMAIL===="+details);
		//String mail=request.getParameter("email");
		EMailer.send("sreekanth.nilu@gmail.com","samsung@26",email,"Your Secrete key details",details);
		
		
		Sendkeydao skd=new Sendkeydao();
		Profilebean pb=new Profilebean();
		pb.setFileid(fileid);
		pb.setOwnername(ownername);
		pb.setFilename(filename);
		pb.setUsername(username);
		pb.setSecretekey(key);
		try{
		int i=skd.sendkey(pb);
		if(i!=0){
			RequestDispatcher rd=request.getRequestDispatcher("ViewRequestedfileservlet?status=Request Accepted and Secrete key sent to mail successfully");
			rd.include(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("ViewRequestedfileservlet?status=Faild Try Again");
			rd.include(request, response);
		}
		}
		catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("ViewRequestedfileservlet?status=Some Internal Problem Occured Try After Some Time");
			rd.include(request, response);
		}
	}

}
