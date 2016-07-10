<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Users</title>
</head>
<body>
<h1>Users List</h1>
<h3><a href="add">Add User</a></h3>

<c:if test="${!empty users}">
	<table align="left" border="1">
		<tr>
			<th>User ID</th>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>			
			<th>Gender</th>
			<th>Age</th>
			<th>Phone</th>
			<th>ZIP</th>
			<th>Edit</th>
		</tr>

		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.userId}"/></td>
				<td><c:out value="${user.firstName}"/></td>
				<td><c:out value="${user.middleName}"/></td>
				<td><c:out value="${user.lastName}"/></td>
				<td><c:out value="${user.gender}"/></td>
				<td><c:out value="${user.age}"/></td>
				<td><c:out value="${user.phone}"/></td>
				<td><c:out value="${user.zip}"/></td>
				<td align="center"><a href="edit?id=${user.userId}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>