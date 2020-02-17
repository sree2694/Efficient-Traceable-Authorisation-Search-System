<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

		<title>My JSP 'Registration.jsp' starting page</title>


		<link href="css/a.css" rel="stylesheet" type="text/css" media="all" />


		<link href="css/a.css" rel="stylesheet" type="text/css" media="all" />
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js">
</script>

		<script type="text/javascript">
function validate() {

	document.getElementById("msguid").innerHTML = "";
	document.getElementById("msgpass").innerHTML = "";
	document.getElementById("msgcpass").innerHTML = "";
	document.getElementById("msguname").innerHTML = "";
	document.getElementById("msgemail").innerHTML = "";
	document.getElementById("msgmob").innerHTML = "";
	document.getElementById("msgeventdate").innerHTML = "";
	document.getElementById("msguaddress").innerHTML = "";
	if (document.getElementById("uid").value == "") {

		document.getElementById("msguid").innerHTML = "Please Enter Login ID";
		return false;
	}
	if (document.getElementById("pass").value == "") {

		document.getElementById("msgpass").innerHTML = "Please Enter Password";
		return false;
	}
	if (document.getElementById("cpass").value == "") {
		document.getElementById("msgcpass").innerHTML = "Please Enter Confirm Password";
		return false;
	}
	if (document.getElementById("cpass").value != document
			.getElementById("pass").value) {
		document.getElementById("msgcpass").innerHTML = "These passwords don't match. Try again?";
		return false;
	}
	var username = document.getElementById("uname");
	var filter = /^([a-zA-Z])+$/;
	if (!filter.test(username.value)) {
		document.getElementById("msguname").innerHTML = "Please Enter valid User Name";
		return false;
	}

	if (document.getElementById("email").value == "") {
		document.getElementById("msgemail").innerHTML = "Please Enter Email ID";
		return false;
	}
	if (document.getElementById("email").value != "") {
		var email = document.getElementById('email');
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email.value)) {
			document.getElementById("msgemail").innerHTML = "Please provide a valid email address";

			return false;
		}
	}

	if (document.getElementById("mob").value == "") {
		document.getElementById("msgmob").innerHTML = "Please Enter Mobile Number";
		return false;
	}
	if (document.getElementById("eventdate").value == "") {
		document.getElementById("msgeventdate").innerHTML = "Plealse Enter Date of Birth";
		return false;
	}
	if (document.getElementById("uaddress").value == "") {
		document.getElementById("msguaddress").innerHTML = "Plealse Enter Address";
		return false;
	}
	if (document.getElementById("mob").value != "") {
		var inputtxt = document.getElementById("mob").value;
		var phoneno = /^\d{10}$/;
		if (inputtxt.match(phoneno)) {
			return true;
		} else {
			document.getElementById("msgmob").innerHTML = "Not a valid Phone Number";
			return false;
		}

	}

}
</script>
	</head>

	<body>


		<center>
			<div style="width: 1000px; height: auto; margin-top: -15px;">
				<jsp:include page="Header.jsp"></jsp:include>
				<div style="margin-top: -3px;">
					<jsp:include page="HomeMenu.jsp"></jsp:include>

				</div>
			</div>
		</center>
		<center>
			<h3>
				<font color="Red" size="6">REGISTER HERE</font>
			</h3>
			<form action="RegistrationServlet" name="event1"
				onsubmit="return validate();">
				<table>
					<tr>
						<td colspan="2" style="">
							<label
								style="color: red; font-style: italic; text-align: center;">
								<%
									String status = request.getParameter("status");
									if (status != null) {
										out.println(status);
									}
								%>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Login ID :
							</p>
						</td>
						<td>
							<input type="text" name="uid" id="uid" class="input_text"
								value="" placeholder="Create Loginid" required="">
							<label id="msguid"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Password :
							</p>
						</td>
						<td>
							<input type="password" name="pass" id="pass"
								class="input_password" value="" placeholder="Create Password"
								required="">
							<label id="msgpass"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Confirm Password :
							</p>
						</td>
						<td>
							<input type="password" name="cpass" id="cpass"
								class="input_password" value="" placeholder="ReEnter Password"
								required="">
							<label id="msgcpass"
								style="color: red; font-size: 16px; font-style: italic;"></label>

						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								User Name :
							</p>
						</td>
						<td>
							<input type="text" name="uname" id="uname" class="input_text"
								value="" placeholder="Enter Your Good Name" required="">
							<label id="msguname"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Email :
							</p>
						</td>
						<td>
							<input type="text" name="email" id="email" class="input_text"
								value="" placeholder="Enter EmailId" required="">
							<label id="msgemail"
								style="color: red; font-size: 16px; font-style: italic;"></label>

						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Mobile No :
							</p>
						</td>
						<td>
							<input type="text" name="mob" id="mob" class="input_text"
								value="" placeholder="Plz Enter Valid Mobile Number" required="">
							<label id="msgmob"
								style="color: red; font-size: 16px; font-style: italic;"></label>

						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					
					
					<tr>
						<td>
							<p>
								Gender :
							</p>
						</td>
						<td class="input_text">
							M
							<input type="radio" name="g" id="g" value="M" checked="checked" />
							&nbsp; F
							<input type="radio" name="g" id="g" value="F" />
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Address :
							</p>
						</td>
						<td>
							<textarea name="uaddress" id="uaddress" class="input_a"></textarea>

						</td>
					</tr>
					<tr>
						<td>

						</td>
						<td>
							<label id="msguaddress"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>

					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
									<td>Role:</td>
                                    <td>
	<select id="role" name="role" required> 
      <option value="">---Select Role---</option> 
     <option value="DataOwner">Data Owner</option> 
     <option value="DataUser">Data User</option> 
   
     
      </select> 
  
									</td>
									<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
									<tr>
						<td></td>
						<td>
							<input type="submit" class="submit" value="Register">
						</td>
					</tr>
				</table>
			</form>
		</center>
		</div>

		</div>
		</center>
		<div style="margin-top: -3px;">
			<jsp:include page="Footer.jsp"></jsp:include>
		</div>
	</body>
</html>