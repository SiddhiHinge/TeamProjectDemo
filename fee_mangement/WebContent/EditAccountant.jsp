<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    text-align: center;
    font-size: 20px;
    font-style: italic;
    background-color: paleturquoise;
    position: absolute;
    top: 45%;
    left: 50%;
    transform: translate(-50%, -50%);
}

 

h2 {
    text-align: center;
    font-style: oblique;
    font-size: 30px;
}

 

select {
    font-size: 18px;
    width: 100%;
    font-style: oblique;}
    
form {
    width: 90%;
    margin: auto;
    padding: 35px;
    border-radius: 15px;
    border: 3px solid black;
}

 

.myButton {
    background-color: navy;
    width: 35%;
    color: white;
    margin-top: 30px;
    height: 35px;
    font-style: italic;
    font-size: 20px;
    border-radius: 8px;
}

 

input {
    font-family: monospace;
    font-size: 18px;
    text-align: center;
}
</style>
</head>

<% Accountant accountant=(Accountant)request.getAttribute("accountant"); %>

<body>
<h2>Edit Accountant Form</h2>
	<form action="editAccountant">
		<input type="hidden"  name="requestAction" value="edit" />
		<table>
			<tr>
			<td>Accountant Name:</td>
			<td><input type="text" name="accName" value="<%=accountant.getAccName()%>" /></td>
			</tr>
			
			<tr>
			<td>Email Id:</td>
			<td><input type="text" name="accEmail" value="<%=accountant.getAccEmail()%>" /></td>
			</tr>
			
			<tr>
			<td>Password:</td>
			<td><input type="password" name="accPassword" value="<%=accountant.getAccPassword()%>" /></td>
			</tr>
			
			<tr>
			<td>Contact Number:</td>
			<td><input type="text" name="accContact" value="<%=accountant.getAccName()%>" /></td>
			</tr>
			
		</table>
		<br>
		<input type="submit" class="myButton" value="Edit Accountant" />
		<br><br>
		<a href="editAccountant?requestAction=logout">LogOut</a>
	</form>
</body>
</html>