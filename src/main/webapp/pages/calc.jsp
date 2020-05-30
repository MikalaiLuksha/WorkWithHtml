<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc</title>
    <style>
        .stms {
            color: black;
        }

    </style>
</head>
<body>
<form action="/calc" method="post">
    <input type="text" name="num1" placeholder="number 1">
    <select name="operation">
        <option disabled>Enter operation</option>
        <option value="plus"> + </option>
        <option value="minus"> - </option>
        <option value="times"> * </option>
        <option value="div"> / </option>
    </select>
    <input type="text" name="num2" placeholder="number 2">
    <button>Calc</button>
</form>


${requestScope.res}

<ul class="stms">
<a href="/">Main</a>
</ul>


</body>
</html>
