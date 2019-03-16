<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person form binded</title>
</head>
<body>
    <form:form method="post" modelAttribute="person">
        <label for="login">Login <form:input type="text" path="login" id="login"></form:input></label>
        <label for="password">Password <form:input type="password" path="password" id="password"></form:input></label>
        <label for="email">Email <form:input type="email" path="email" id="email"></form:input></label>
        <div><input type="submit"></div>
    </form:form>
</body>
</html>
