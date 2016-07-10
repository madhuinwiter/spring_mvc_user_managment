<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add User</title>
	</head>
	<body>
		<h2>Add User Data</h2>
		<form:form method="POST" action="/UserManagement/save">
	   		<table>
			    <%-- <tr>
			        <td><form:label path="userId">User ID:</form:label></td>
			        <td><form:input path="userId" value="${user.userId}" readonly="true"/></td>
			    </tr> --%>
			    <tr>
			        <td><form:label path="firstName">First Name:</form:label></td>
			        <td><form:input path="firstName" value="${user.firstName}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="middleName">Middle Name:</form:label></td>
			        <td><form:input path="middleName" value="${user.middleName}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="lastName">Last Name:</form:label></td>
			        <td><form:input path="lastName" value="${user.lastName}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="gender">Gender:</form:label></td>
			        <td><spring:bind path="gender">
							<c:forEach items='${genderList}' var='genderName'>
								<c:choose>
									<c:when test="${genderName eq user.gender}">
										<input type="radio" name="gender" value="${genderName}"
											checked="checked">${genderName}
									</c:when>
									<c:otherwise>
										<input type="radio" name="gender" value="${genderName}">${genderName}
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</spring:bind>
					</td>
			    </tr>
			    <tr>
			        <td><form:label path="age">Age:</form:label></td>
			        <td><form:input path="age" value="${user.age}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="phone">Phone:</form:label></td>
			        <td><form:input path="phone" value="${user.phone}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="zip">ZIP:</form:label></td>
			        <td><form:input path="zip" value="${user.zip}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
			<form:hidden path="userId" value="${user.userId}" />
		</form:form>
		
  <c:if test="${!empty users}">
		<h2>Users List</h2>
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