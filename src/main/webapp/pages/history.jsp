<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>

<h2>${"History"}</h2>

<ul style="list-style: decimal">

<%
    List <String> result = (List) request.getSession().getAttribute("result");
    for (int i = 0; i < result.size(); i++) {
        out.println ( "<li>" + result.get(i) + "</li>" );
    }
%>
</ul>

<a href="/">main</a>

</body>
</html>
