<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="book">
        <label for="title">Title <form:input type="text" path="title" id="title"></form:input></label> <br/>
        <label for="authors">Authors <form:select multiple="true" path="authors" id="authors">
            <form:options items="${authors}"
                          itemLabel="fullName"
                          itemValue="id"></form:options>
        </form:select></label> <br/>
        <label for="publisher">Publisher <form:select path="publisher.id" id="publisher">
            <form:options items="${publishers}"
                          itemLabel="name"
                          itemValue="id"></form:options>
        </form:select></label> <br/>
        <label for="rating">Rating <form:input type="number" step="1" path="rating" id="rating"></form:input></label> <br/>
        <label for="description">Description <form:textarea path="description" id="description"></form:textarea></label> <br/>
        <label for="pages">Pages <form:input type="number" step="1" path="pages" id="pages"></form:input></label> <br/>
        <div><form:errors path="pages"></form:errors></div>

        <div><input type="submit"></div> <br/>
        <div><form:errors path="*"></form:errors></div>
    </form:form>
</body>
</html>
