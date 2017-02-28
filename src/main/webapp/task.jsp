<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calendar</title>
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
    <h2>Список задач</h2>
    <table class="table table-striped">
        <tr>
            <td><b>#</b></td>
            <td><b>Задача</b></td>
            <td><b>Дата</b></td>
            <td><b>Исполнено</b></td>
        </tr>

        <jsp:useBean id="listOfTask" scope="request" type="java.util.List"/>
        <c:forEach items="${listOfTask}" var="task">
            <tr>
                <td><c:out value="${task.getId()}"></c:out></td>
                <td><c:out value="${task.getEvent()}"></c:out></td>
                <td><c:out value="${task.getDate()}"></c:out></td>
                <td><c:out value="${task.getIs_complete()}"></c:out></td>

            </tr>
        </c:forEach>
    </table>
    <a href="/">На главную</a>
</div>
</body>
</html>
