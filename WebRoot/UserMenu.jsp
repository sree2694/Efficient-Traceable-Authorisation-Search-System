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
 					 <a href="UserHome.jsp" class="top_link"><span>Home</span> </a>						
					</li>
					<li class="top">
 					 <a href="ViewProfileServlet" class="top_link"><span>ViewProfile</span> </a>						
					</li>
					<li class="top">
 					 <a href="MovieRatingServlet" class="top_link"><span>ViewMovies</span> </a>	</li>					
					
				<li class="top">
 					 <a href="ViewRecommendmovieservlet" class="top_link"><span>Recommend Movies</span> </a>						
					</li>
					<li class="top">
						<a href="TopmovieServlet" class="top_link"><span>TopMovies</span> </a>
					</li>
					<li class="top">
 					 <a href="changepassword.jsp" class="top_link"><span>ChangePassword</span> </a>						
					</li>
					
					<li class="top">
						<a href="Logout.jsp" class="top_link"><span>Logout</span> </a>
					</li>
					<!--<li class="top">
						<a href="ViewServlet" class="top_link"><span>ViewProfile</span> </a>
					
					<li class="top">
						<a href="DENBRegistration.jsp" class="top_link"><span>DENBRegistration</span> </a>
					</li>
		--></ul>
  </body>
</html><br/>
