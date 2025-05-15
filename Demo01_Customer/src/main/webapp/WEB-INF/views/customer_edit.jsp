
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Edit Customer</h4>

    <form action="customer-update" method="post">
        <input type="text" name="id" value="${customer.id}" readonly />

        <div>
            <label for="fullName">Full Name</label>
            <input type="text" name="fullName" id="fullName" value="${customer.fullName}" />
        </div>
        <div>
            <label for="email">Email</label>
            <input type="text" name="email" id="email" value="${customer.email}" />
        </div>

        <div>
            Gender
            <input type="radio" name="gender" value="MALE" <c:if test="${customer.gender.equals('MALE')}">checked</c:if> /> Male
            <input type="radio" name="gender" value="FEMALE" <c:if test="${customer.gender.equals('FEMALE')}">checked</c:if> /> Female
        </div>

        <div>
            Customer Type
            <input type="radio" name="customerType" value="VIP" <c:if test="${customer.customerType.equals('VIP')}">checked</c:if> /> VIP
            <input type="radio" name="customerType" value="STANDARD" <c:if test="${customer.customerType.equals('STANDARD')}">checked</c:if> /> STANDARD
        </div>
        <div>
            <input type="submit" value="Update" />
        </div>
    </form>
</body>
</html>
