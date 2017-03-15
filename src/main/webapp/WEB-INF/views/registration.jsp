<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Registration</title>
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
            <li class="active"><a href="/registration"><span class="glyphicon glyphicon-user"></span> Регистрация</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Войти</a></li>
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

<div class="container">
    <div class="col-md-4 text-right">
        <h1>Регистрация:</h1></br>
    <form action="/registration"  method="post">
        <div class="form-group">
            <label for="firstname">Firstname:</label>
            <input type="text" name="firstname" id="firstname" required>
        </div>
        <div class="form-group">
            <label for="lastname">Lastname:</label>
            <input type="text" name="lastname" id="lastname" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>
        </div>
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" name="login" id="login" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" required>
        </div>
        <input type="submit" class="btn btn-primary" value="Сохранить" formmethod="post">
    </form>
    </div>
</div>
</body>
</html>