<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calendar</title>
</head>
<body>
<h2>Список задач</h2>

<div>
    <table border="1" width="100%" cellpadding="5">
        <tr>
            <td><b>Номер</b></td>
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
</div>
</body>
</html>
