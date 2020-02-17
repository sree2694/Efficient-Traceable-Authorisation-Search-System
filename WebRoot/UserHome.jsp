<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserHome.jsp' starting page</title>
    
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
  <center>
  <%

HttpServletResponse httpResponse = (HttpServletResponse)response;

httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
httpResponse.setHeader("Pragma","no-cache"); 
httpResponse.setDateHeader ("Expires", 0); 

String uid=(String)session.getAttribute("uname");
if(uid==null)
{

response.sendRedirect("Login.jsp?status=Please Enter UserName and Password");
return ;
}


%>
<div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="UserMenu.jsp"></jsp:include>
			<div class="signup" style="margin-top: -1px; width: 100%;">
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
			
			</div>
			</div>
			</div>
			</center>
    <div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
    
  </body>
</html>
