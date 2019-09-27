<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Admin Page</h1>
	
	<form action="addAdmin">
	FirstName: <input type="text" name="firstName"><br><br>
	LastName: <input type="text" name="lastName"><br><br>
	Password: <input type="password" name="password"><br><br>
	Email: <input type="text" name="email"><br><br>
	<input type="submit" name="submit">
	</form>
	<br>
	<hr>
	<br>
	<Form action="getAdmin">
	Id: <input type="text" name="id">
	 <input type="submit" name="submit">
	</Form>
	<br>
	<div>
	<h2>Admin: ${admin }</h2>
	</div>
	
</body>
</html>