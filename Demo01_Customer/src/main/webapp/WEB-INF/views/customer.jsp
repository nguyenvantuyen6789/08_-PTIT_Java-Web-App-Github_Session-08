
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>List Customer</h4>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Customer Type</th>
        </tr>
        <c:forEach var="item" items="${customers}">
            <tr>
                <td>${item.id}</td>
                <td>${item.fullName}</td>
                <td>${item.email}</td>
                <td>${item.gender}</td>
                <td>${item.customerType}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
