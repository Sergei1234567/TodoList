<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="text-align: center">
    <form method="post" action="item">
        <label><input type="text" name="item"></label><br>
        <input type="submit" value="Ok"><br>
    </form>

    <ul style="list-style: none;">
        <c:forEach var="todoItem" items="${requestScope.todoList}">
            <div id="${todoItem}">
                <li>Задача: <c:out value="${todoItem}"/>
                    <span style="color: red; cursor: pointer"
                          onclick="deleteItem('${todoItem}')">&#10006;</span>
                </li>
                <hr/>
            </div>
        </c:forEach>
    </ul>
</div>