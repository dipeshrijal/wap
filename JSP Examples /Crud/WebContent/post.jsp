<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Add new post</title>
</head>
<body>

	<form method="POST" action='PostController' name="frmAddUser">
		Post ID : <input type="text" readonly="readonly" name="postid"
			value="<c:out value="${post.postid}" />" /> <br /> Title : <input
			type="text" name="title" value="<c:out value="${post.title}" />" />
		<br /> Description : <input type="text" name="description"
			value="<c:out value="${post.description}" />" /> <br /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>