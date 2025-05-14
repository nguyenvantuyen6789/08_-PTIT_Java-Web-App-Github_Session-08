
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Add Customer</h4>

    <form action="customer-save" method="post">
        <div>
            <label for="fullName">Full Name</label>
            <input type="text" name="fullName" id="fullName" />
        </div>
        <div>
            <label for="email">Email</label>
            <input type="text" name="email" id="email" />
        </div>
        <div>
            <input type="submit" value="Save" />
        </div>
    </form>
</body>
</html>
