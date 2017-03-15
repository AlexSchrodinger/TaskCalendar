<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Календарь задач</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/">Home</a></li>
            <li><a href="/calendar/all">Задачи</a></li>
            <li><a href="/admin/panel">Админка</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/registration"><span class="glyphicon glyphicon-user"></span> Регистрация</a></li>
            <li class="active"><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Войти</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <% if (request.getSession().getAttribute("firstName") != null) {%>
    <div class=" text-center col-md-3 col-md-offset-10">
        <h4>Пользователь, <%= request.getSession().getAttribute("firstName") %></h4>
        <a href="/logout">Выйти</a>
    </div>
    <%}%>
</div>

<div class="container text-center">
    <h3>Авторизация:</h3>
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <div class="input-group col-md-4 col-md-offset-4">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input type="text" class="form-control" name="j_username" placeholder="Login" required = "required"/>
        </div>
        <div class="input-group col-md-4 col-md-offset-4">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input type="password" class="form-control" name="j_password" placeholder="Password" required = "required" />
        </div>
        <button type="submit" class="btn btn-primary" >Войти</button>
    </form>
</div>

<%--<div class="container text-center">--%>
    <%--<h3>Авторизация:</h3>--%>
    <%--<form action="/login" method="post" >--%>
        <%--<div class="input-group col-md-4 col-md-offset-4">--%>
            <%--<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>--%>
            <%--<input type="text" class="form-control" name="login" placeholder="Login" required = "required"/>--%>
        <%--</div>--%>
        <%--<div class="input-group col-md-4 col-md-offset-4">--%>
            <%--<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>--%>
            <%--<input type="password" class="form-control" name="password" placeholder="Password" required = "required" />--%>
        <%--</div>--%>
        <%--<input type="submit" class="btn btn-primary" value="login" formmethod="post" />--%>
    <%--</form>--%>
<%--</div>--%>
</body>
</html>