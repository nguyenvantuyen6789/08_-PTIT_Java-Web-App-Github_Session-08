<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h4>Trang chủ</h4>
    <script>
        // c1: chuyển sang path /customer js
        // window.location.href = "/customer"
    </script>

    <%-- c2: sử dụng jsp chuyển sang /customer --%>
<%--    <jsp:forward page="/customer" />--%>

    <%
        // c3: dùng đối tượng ẩn response trong jsp
        response.sendRedirect("/customer");
    %>

</body>
</html>