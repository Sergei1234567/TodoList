<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Todo List</title>
</head>

<body>
<form method="post" action="item">
    <label><input type="text" name="item"></label><br>
    <input type="submit" value="Ok"><br>
</form>

<c:forEach var="t" items="${requestScope.todoList}">
    <ul>

        <li>Задача: <c:out value="${t}"/></li>

    </ul>
    <hr/>

</c:forEach>
<script>
    // Create a "close" button and append it to each list item
    var myNodelist = document.getElementsByTagName("LI");
    var i;
    for (i = 0; i < myNodelist.length; i++) {
        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodelist[i].appendChild(span);
    }

    // Click on a close button to hide the current list item
    var close = document.getElementsByClassName("close");
    var i;
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function() {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }
</script>

</body>
</html>