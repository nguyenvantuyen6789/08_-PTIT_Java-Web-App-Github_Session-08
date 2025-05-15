
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
            Gender
            <input type="radio" name="gender" value="MALE" /> Male
            <input type="radio" name="gender" value="FEMALE" /> Female
        </div>

        <div>
            Customer Type
            <input type="radio" name="customerType" value="VIP" /> VIP
            <input type="radio" name="customerType" value="STANDARD" /> STANDARD
        </div>
        <div>
            <input type="submit" value="Save" />
        </div>
    </form>
</body>
</html>
