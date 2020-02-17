<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.etass.dto.Profilebean"%>
<%@page import="com.etass.dto.Profilebean"%>
<%@page import="com.etass.dao.RequestOwnerdao"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'Productcomment.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<!--<link rel="stylesheet" type="text/css" href="css/tables.css">
		
	--><script type="text/javascript">
function validator() {

		document.getElementById("msgimage").innerHTML = "";
		if (document.getElementById("image").value == "") {

		document.getElementById("msgimage").innerHTML = "Please Upload File";
		return false;
	}
		</script>
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
				<div style="margin-top: -3px;"><jsp:include
						page="DataOwnerMenu.jsp"></jsp:include></div>
				<div class="signup" style="margin-top: -1px; width: 100%;">
					<h2>
						<font color="red">File Upload Here</font>
					</h2>
					<center>
						<%
							String userid=(String)session.getAttribute("uname");
							
							RequestOwnerdao rod=new RequestOwnerdao();
							ArrayList<Profilebean> list=rod.getdata(userid);
						%>

						<%
							String status = request.getParameter("status");
							if (status != null) {
								out.println(status);
							}
						%>
						<table border="2" align="center">

							<%
								for (Profilebean pb : list) {
							%>
							<tr>
								<form action="FileUploadServlet">
									
									
									
										<table border="1" width="530" height="186">

											<tr>
												<td align='left'>
													User_id
												</td>
												<td align="left">
				<font color="#0080ff"><input type="text" name="uid"	value="<%=pb.getLoginid()%>" readonly="readonly">
													</font>
													<br>
												</td>
											</tr>

											
											<tr>
												<td align='left'>
													UserName
												</td>
												<td align="left">
												<font color="#0080ff"><input type="text" name="uname"	value="<%=pb.getUsername()%>" readonly="readonly">
													</font>
													<br>
												</td>
											</tr>
											<tr>
												<td align="left">
													Mail_Id
												</td>
												<td align="left">
												<font color="#0080ff"><input type="text" name="mid"	value="<%=pb.getEmail()%>" readonly="readonly">
													</font>
													<br>
												</td>
											</tr>
											<tr>
												<td align='left'>
													MobileNo
												</td>
												<td align="left">
												<font color="#0080ff"><input type="text" name="mno"	value="<%=pb.getMobileno()%>" readonly="readonly">
													</font>
													<br>
												</td>
											</tr>
											<tr>
												<td align='left'>
													Address
												</td>
												<td align="left">
												<font color="#0080ff"><input type="text" name="add"	value="<%=pb.getAddress()%>" readonly="readonly">
													</font>
													<br>
												</td>
											</tr>
																						
												<tr>
                        <td>UploadFile:</td>
                        <td><input type="file" name="file" id="image" class="input_text" value="">
                         <label id="msgimage"  style="color: red;font-size: 16px;font-style: italic;"></label>
                      </td>
                    </tr>
													
											<tr>
												<td></td>
												<td>
													<input type="submit" value="submit" />
												</td>
											</tr>
										</table>
								</form>

							</tr>
							<%
								}
							%>
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
