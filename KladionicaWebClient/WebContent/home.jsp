<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h3>DJESTE </h3>
	<hr>
	<table>
		<tr>
			<th>Ime</th>
			<th>Prezime</th>
			<th>Email</th>
			<th>Username</th>
			<th>Stanje</th>
		</tr>
			<tr>
				<td>${user.name}</td>
				<td>${user.surname}</td>
				<td>${user.email}</td>
				<td>${user.username}</td>
				<td>${user.credit}</td>
			</tr>
	</table>



</body>
</html>