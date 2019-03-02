<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adding students</title>
</head>
<body>

	

	<form action="/insertStudent" method="post">
		<span>cod:</span> <input type="text" name="cod"> <span>name:</span> <input type="text" name="name"> <br /> <input
			type="submit">
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<td>Cod</td>
				<td>Name</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${listAllStudents}">
				<tr>
					<td><c:out value="${student.cod}" /></td>
					<td><c:out value="${student.name}" /></td>
					<td><a href="/deleteStudent?cod=${student.cod}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div>
		<a href="index.jsp">Return to index</a>
	</div>

</body>
</html>