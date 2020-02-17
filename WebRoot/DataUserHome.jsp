<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AdminHome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% String username=(String)session.getAttribute("username");%>
  <center><div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;">
			<jsp:include page="DataUserMenu.jsp"></jsp:include>
			<div style="margin-top: -20px; background-image: Images/header.jpg">
			<br/>
			<br/>
			<br/>
			<br/><br/><br/><br/><br/>
			<h2><font color="orange" face='Edwardian Script ITC' size='8'>Welcome To &nbsp; </font><% out.println("<font color='green' face='Edwardian Script ITC' size='8'>"+username+"</font>"); %></h2>
				
			</div>
  </div>
  <br/>
			<br/>
			<br/>
			<br/><br/><br/><br/><br/>
  <div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
  </div>
    </center>
  </body>
</html>
