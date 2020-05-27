<html>
<body>
<h2>Hello ${sessionScope.currentUser.name}</h2>

<a href="/reg">Reg</a>
<a href="/auth">Auth</a>
<a href="/calc">Calc</a>
<a href="/logout">logout</a>
</form>
${requestScope.message}
</body>
</html>
