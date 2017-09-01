<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Employees</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="emp">
				<tr>
					<td><c:out value="${emp.id}" /></td>
					<td><c:out value="${emp.firstname}" /></td>
					<td><c:out value="${emp.lastname}" /></td>
					<td>Update</td>
					<td>Delete</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="create">Add Employee</a>
	</p>
</body>
</html>