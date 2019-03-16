<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person form binded</title>
</head>
<body>
    <form:form method="post" modelAttribute="student">
        <label for="name">Login <form:input type="text" path="name" id="name"></form:input></label>
        <div><input type="submit"></div>
    </form:form>
</body>
</html>
