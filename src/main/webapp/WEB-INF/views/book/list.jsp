<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<div>Książki:</div>
<div>
    <c:forEach items="${books}" var="book">
        <div><c:out value="${book.title}, ${book.publisher.name}"></c:out></div>
    </c:forEach>
</div>
</body>
</html>
