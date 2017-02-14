<%@ page import="java.util.List" %><%--

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>list_TV</title>
</head>
<body>

<%out.println("<h2>" + con.get(3).getId() + "</h2>");
out.println("<h2>" + con.get(3).getName() + "</h2>");
out.println("<h2>" + con.get(3).getPrice() + "</h2>");%>
<div><form><a href='GetForm.htm'>Buy</a></form></div>
<div><form><a href='reviewForm.html'>review</a></form></div>
<div><form><a href='/ShowReviewServlet'>show review</a></form></div>
</body>
</html>
