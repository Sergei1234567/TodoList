<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Todo List</title>
</head>

<body>
<form method="post" action="item">
    <div>
    <label><input type="text" name="item"></label><br>
    <input type="submit" value="Ok"><br>
    </div>
</form>

<c:forEach var="t" items="${requestScope.todoList}">
    <ul>

        <li>Задача: <c:out value="${t}"/></li>

    </ul>
    <hr/>

</c:forEach>


</body>
</html>