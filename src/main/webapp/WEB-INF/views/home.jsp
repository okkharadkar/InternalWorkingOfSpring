<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My JSP Page</title>
</head>
<body>

    <h1>Welcome to My JSP Page!</h1>

    <%-- JSP Scriptlet Example --%>
    <%
        String message = "This is a dynamic message from JSP.";
        out.println("<p>" + message + "</p>");
    %>

    <%-- JSP Expression Example --%>
    <p>Current time: <%= new java.util.Date() %></p>

</body>
</html>