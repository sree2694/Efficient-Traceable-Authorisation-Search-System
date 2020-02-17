<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.etass.dto.Profilebean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/tables.css">

  </head>
  
  <body>
  <%
				String u = (String) session.getAttribute("uname");
				if (u == null) {
					String target = "DataUserlogin.jsp?status=Please Enter UserName and Password";
					RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request, response);
				}
			%>
   <center>
<div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="CloudMenu.jsp"></jsp:include></div>
			<div class="signup" style="margin-top: -1px; width: 100%;">
			
			<center>
  <%
    ArrayList<Profilebean> al=new ArrayList<Profilebean>();
    al=(ArrayList)session.getAttribute("list");
     %>
   <center><h1><font style="color: rgb(0, 0, 136)" face="Algerian">View All Owners</font></h1></center>
<table border='1px' align='center' bordercolor="black">
<tr>
<th><font color="blue" >USERID</font></th>
 <th><font color="blue" >USERNAME</font></th>
 <th><font color="blue">EMAIL</font></th>
 <th><font color="blue">MOBILENO</font></th>
 <th><font color="blue">GENDER</font></th>
<th><font color="blue">ADDRESS</font></th>

 
  </tr>
 
  <%for(Profilebean pb:al){ %>
<tr>
<td>
  <font color="green"><%=pb.getLoginid()%></font>
</td>
 <td>
  <font color="green"><%=pb.getUsername()%></font>
</td>
  
 <td>
<font color="green"><%=pb.getEmail()%></font>
 </td>
 
  
  <td>
  <font color="green"><%=pb.getMobileno()%></font>
  </td>
  
  <td>
<font color="green"><%=pb.getGender()%></font>
 </td>
 
  
  <td>
<font color="green"><%=pb.getAddress()%></font>
</td>
  
 

 </tr>
  
  
  
  
  <%  } %>
  
  
  
  
  
</table>
 </center>
 </div>
 </div>
 </center>

   <div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
 
  
  
  </body>
</html>
