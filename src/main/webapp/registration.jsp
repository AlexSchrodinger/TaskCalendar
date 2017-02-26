<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Регистрация</h1>
<form action="/registration" method="post">
    <label for="firstname">Firstname:</label>
    <input type="text" name="firstname" id="firstname" value=""></br>

    <label for="lastname">Lastname:</label>
    <input type="text" name="lastname" id="lastname" value=""></br>

    <label for="email">Email:</label>
    <input type="text" name="email" id="email" value=""></br>

    <label for="login">Login:</label>
    <input type="text" name="login" id="login" value=""></br>

    <label for="password">Password:</label>
    <input type="password" name="password" id="password" value=""></br>

    <input type="submit" value="Submit" formmethod="post">
</form>
</body>
</html>