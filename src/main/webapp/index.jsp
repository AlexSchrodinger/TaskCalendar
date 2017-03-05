<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
    <% if (request.getSession().getAttribute("firstName") != null) {%>
    <div class=" text-center col-md-4 col-md-offset-10">
        <h4>Пользователь, <%= request.getSession().getAttribute("firstName") %></h4>
        <a href="/logout">Выйти</a>
    </div>
    <%}%>
</div>

<div class="container">
    <H3>Добро пожаловать на главную страницу</H3>
    <div class="list-group col-md-6">
        <a href="/registration" class="list-group-item">Регистрация</a>
        <a href="/login" class="list-group-item">Авторизация</a>
        <a href="/calendar/task" class="list-group-item">Задачи</a>
    </div>
</div>
</body>
</html>