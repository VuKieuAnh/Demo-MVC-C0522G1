<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 19/08/2022
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach khach hang</h1>
<table border="1px">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>address</th>
    </tr>
    <c:forEach var="customer" items="${dskh}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
