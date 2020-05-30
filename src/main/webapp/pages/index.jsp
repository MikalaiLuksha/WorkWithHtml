<html>

<head>
    <style>
        .breadcrumbs {
            margin: 0; /* Убираем отступы */
            padding: 10px; /* Поля вокруг текста */
            background: #b2d235; /* Цвет фона */
        }
        .breadcrumbs li {
            display: inline-block; /* Размещаем список по горизонтали */
        }
        .breadcrumbs a {
            color: #000000; /* Цвет ссылок */
            text-decoration: underline black;
        }
        .breadcrumbs li + li::before {
            content: '/'; /* Разделитель ссылок */
            padding: 0 7px; /* Расстояние вокруг разделителя */
        }
    </style>

</head>
<body>
<h2>${requestScope.messageHello}</h2>

<ul class="breadcrumbs">
    <li><a href="/reg">Registration</a></li>
    <li><a href="/auth">Authorization</a></li>
    <li><a href="/calc">Calculation</a></li>
    <li><a href="/history">History</a></li>
    <li><a href="/logout">Logout</a></li>
</ul>


<%--<a href="/reg">Reg</a>--%>
<%--<a href="/auth">Auth</a>--%>
<%--<a href="/calc">Calc</a>--%>
<%--<a href="/logout">Logout</a>--%>
<%--<a href="/history">History</a>--%>
<h4>${requestScope.message}</h4>
</body>
</html>
