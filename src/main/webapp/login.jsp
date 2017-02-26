<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <h2>Авторизация:</h2>
    <form action="/login" method="post">
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" value="" ></br>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" ></br>

        <input type="submit" value="login" formmethod="post">
    </form>
</div>
<h2>Выйти:</h2>
<div>
    <form action="/logout" method="post">
        <input type="submit" value="logout" formmethod="post">
    </form>
</div>

</body>
</html>