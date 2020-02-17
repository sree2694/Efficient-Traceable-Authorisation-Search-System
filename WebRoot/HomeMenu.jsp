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
 					 <a href="index.jsp" class="top_link"><span>Home</span> </a>					
					</li>
					<li class="top">
 					 <a href="Registration.jsp" class="top_link"><span>Registration</span> </a>						
					</li>
					<li class="top">
 					 <a href="CloudLogin.jsp" class="top_link"><span>Cloud</span> </a>						
					</li>
					
					<li class="top">
 					 <a href="KgcLogin.jsp" class="top_link"><span>KGC</span> </a>						
					</li>
					<li class="top">
						<a href="DataOwnerlogin.jsp" class="top_link"><span>DataOwner</span> </a>
					</li>
					<li class="top">
						<a href="DataUserlogin.jsp" class="top_link"><span>DataUser</span> </a>
					</li>
					</ul>
					
  </body>
</html>
