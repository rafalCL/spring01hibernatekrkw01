<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="book">
    <%--private String title;--%>
    <%--@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)--%>
    <%--private List<Author> authors = new ArrayList<>();--%>
        <%--@Column(scale = 2, precision = 4)--%>
        <%--private BigDecimal rating;--%>
        <%--@ManyToOne(cascade = CascadeType.PERSIST)--%>
        <%--private Publisher publisher;--%>
        <%--@Column(columnDefinition = "TEXT")--%>
        <%--private String description;--%>
        <label for="title">Title <form:input type="text" path="title" id="title"></form:input></label>
        <label for="publisher">Publisher <form:select path="publisher" id="publisher">
            <form:options items="${publishers}"
                          itemLabel="name"
                          itemValue="id"></form:options>
        </form:select></label>
        <%--<label for="email">Email <form:input type="email" path="email" id="email"></form:input></label>--%>
        <div><input type="submit"></div>
    </form:form>
</body>
</html>
