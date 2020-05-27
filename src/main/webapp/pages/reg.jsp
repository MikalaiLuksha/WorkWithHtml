
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reg</title>
</head>
<body>
<form action="/reg" method="post">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="login" placeholder="Login">
    <input type="text" name="password" placeholder="Password">
    <button>Submit</button>
</form>
${requestScope.message}
</body>
</html>
