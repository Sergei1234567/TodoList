<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <form method="post" action="item">
        <label><input type="text" name="item"></label><br>
        <input type="submit" value="Ok"><br>
    </form>

    <c:forEach var="t" items="${requestScope.todoList}">
        <ul id="myUL">
            <li>Задача: <c:out value="${t}"/></li>
        </ul>
        <hr/>
    </c:forEach>
</div>