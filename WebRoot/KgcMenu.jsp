<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Menu.jsp' starting page</title>
    


  <link href="css/menu.css" rel="stylesheet" type="text/css" media="all"/>
<script src="css/HoverMenu.js" type="text/javascript"></script>
  </head>
  
  <body>
  
  
 		 <ul id="nav">
 		 			<li class="top">
 					 <a href="KgcHome.jsp" class="top_link"><span>Home</span> </a>					
					</li>
					<li class="top">
 					 <a href="RequestUserServlet" class="top_link"><span>Request User</span> </a>						
					</li>
					<li class="top">
 					 <a href="RequestOwnerServlet" class="top_link"><span>Request Owners</span> </a>						
					</li>
					
					<li class="top">
 					 <a href="ViewRequestedfileservlet" class="top_link"><span>Send keys</span> </a>						
					</li>
					<li class="top">
						<a href="MalicioususerServlet" class="top_link"><span>Malicious Users</span> </a>
					</li>
					<li class="top">
						<a href="Logout.jsp" class="top_link"><span>Logout</span> </a>
					</li>
					</ul>
					
  </body>
</html>
