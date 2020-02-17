<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Contactus.jsp' starting page</title>
    
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
  <center>
<div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="HomeMenu.jsp"></jsp:include></div>
			<div class="signup" style="margin-top: -1px; width: 100%;">
			   
			<br/>
			<br/>
			<br/>
			<br/>
			<center>
			<h4><font color="red"><i>ContactDetails</i></font></h4>
    <table border="0" width="" height="162" align>
	
	
				<tr>
					<td align='left'> 
					 NAME
					</td>
					<td align='left'>&nbsp;&nbsp;&nbsp;&nbsp; 
							<font color="#0080ff">Naresh i Technologies</font>
					<br></td></tr>
				
					<tr>
					<td align='left'>
					 MOBILE 
					</td>
					<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 
							<font color="#0080ff">9000994005</font>
					<br></td></tr>
					<tr>
					<td align='left'> 
						MAIL ID
					</td>
						<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 
						<font color="#0080ff">projects@nareshit.com</font>
					<br></td>
					</tr>
					<tr>
					<td align='left'>
						PROJECT 
					</td>
						<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; <font color="#0080ff">Neural Attentive Item Similarity Model for Recommendation</font>
					<br></td>
					</tr>
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
