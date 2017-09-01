<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Post Id</th>
				<th>Title</th>
				<th>Description</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td><c:out value="${post.postid}" /></td>
					<td><c:out value="${post.title}" /></td>
					<td><c:out value="${post.description}" /></td>
					<td><a
						href="PostController?action=edit&postId=<c:out value="${post.postid}"/>">Update</a></td>
					<td><a
						href="PostController?action=delete&postId=<c:out value="${post.postid}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="PostController?action=insert">Add Post</a>
	</p>
</body>
</html>