<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
    <body>
        <h1 align="center">Beer Recommendations</h1>
        <p>
            <%--<%
        List styles = (List)request.getAttribute("styles");
        Iterator it = styles.iterator();
        while(it.hasNext()) {
        out.print("<br>try: " + it.next());
        }
        %> --%>
            <c:forEach var="style" items="${styles}">
                try <c:out value="${style}"/><br>
            </c:forEach>

    </body>
</html>
