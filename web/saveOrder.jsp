
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="entity.*"%>
<html>
<head>
    <title>saveOrder</title>
</head>
<body>
<%Order o = (Order) request.getAttribute("o");%>
<jsp:useBean id="OrderBean" class="entity.OrderBean"/>
Order submitted
<ol>
    <li>name:
        <i><jsp:getProperty name="OrderBean" property="mingzi" /></i>
    </li>
    <li>price:
        <i><jsp:getProperty name="OrderBean" property="price" /></i>
    </li>
    <li>order id:
        <i><jsp:getProperty name="OrderBean" property="orderid" /></i>
    </li>

</ol>
<tr>
    <td valign="middle" align="right">
        name:
    </td>
    <td valign="middle" align="left">
        <%=o.getMingzi()%>
    </td>
</tr><br>
<tr>
    <td valign="middle" align="right">
        price:
    </td>
    <td valign="middle" align="left">
        <%=o.getPrice()%>
    </td>
</tr><br>
<tr>
    <td valign="middle" align="right">
        order id:
    </td>
    <td valign="middle" align="left">
        <%=o.getOrderid()%>
    </td>
</tr><br>


<a href="http://localhost:8080/index.html">Home Page</a>
</body>
</html>
