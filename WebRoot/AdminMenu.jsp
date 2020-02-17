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
 					 <a href="AdminHome.jsp" class="top_link"><span>Home</span> </a>						
					</li>
					
					<li class="top">
				<a href="AdminHome.jsp" class="top_link"><span>Movies</span>
				</a>
				<ul class="sub" style="left: 1px; width: 138px;">
					<li>
						<a href="AddMovies.jsp" class="parent"><span>AddMovies</span> </a>
					</li>
					<li>
						<a href="Viewmovieservlet" class="parent"><span>View Movies</span> </a>
					</li>
					
				</ul>
			</li>
					<li class="top">
 					 <a href="similaritysearch.jsp" class="top_link"><span>similarity</span> </a></li>					
					
				<li class="top">
 					 <a href="ViewUserServlet" class="top_link"><span>ViewUsers</span> </a>						
					</li>
					
					<li class="top">
 					 <a href="#" class="top_link"><span>User Reviews</span> </a>						
					</li>
	
 					 <li class="top">
						<a href="Logout.jsp" class="top_link"><span>Logout</span> </a>
					</li>				
					
					</ul>
  </body>
</html><br/>
