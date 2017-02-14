<%@ page import="entity.Review" %>
<%--<%@ page import="java.util.HashMap" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="MongoDBUtil.*" %>--%>
<%--<%@ page import="org.bson.Document" %>--%>
<%--<%@ page import="com.mongodb.client.FindIterable" %>--%>
<%--<%@ page import="com.mongodb.client.MongoCursor" %>--%>
<%--<%@ page import="com.mongodb.*"%>--%>
<%--<%@ page import="com.mongodb.client.*"%>--%>
<%--<%@ page import="org.bson.Document"%>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showReview</title>
</head>
<body>
<%--<%!   static MongoCollection myReviews;%>--%>

    <%--<%!public static void getConnection() {--%>
        <%--MongoClient mongoClient = new MongoClient("localhost", 27017);--%>
        <%--MongoDatabase db = mongoClient.getDatabase("CustomerReview");--%>
        <%--myReviews = db.getCollection("myReviews");--%>

    <%--}%>--%>
    <%--<%!public static HashMap<String, ArrayList<Review>> selectReview() {--%>
    <%--getConnection();--%>
    <%--FindIterable<Document> findIterable = myReviews.find();--%>
    <%--HashMap<String, ArrayList<Review>> reviewHashmap = new HashMap<String, ArrayList<Review>>();--%>
    <%--MongoCursor<Document> cursor = findIterable.iterator();--%>
    <%--while (cursor.hasNext()) {--%>
        <%--Document obj = cursor.next();--%>
        <%--if (!reviewHashmap.containsKey(obj.getString("productName"))) {--%>
            <%--ArrayList<Review> arr = new ArrayList<Review>();--%>
            <%--reviewHashmap.put(obj.getString("productName"), arr);--%>
        <%--}--%>
        <%--ArrayList<Review> listReview = reviewHashmap.get(obj.getString("productName"));--%>
        <%--Review review = new Review(obj.getString("productName"), obj.getString("userName"), obj.getString("productType"), obj.getString("reviewRating"), obj.getString("reviewDate"), obj.getString("reviewText"), obj.getString("zipcode"));--%>
        <%--listReview.add(review);--%>
    <%--}--%>
    <%--return reviewHashmap;--%>
<%--}--%>
<%--%>--%>
<%--<%ArrayList<Review> uu = (ArrayList<Review>) request.getAttribute("uu");%>--%>
Review<br>

<%Review r=(Review) request.getAttribute("r");%>

<%--<%        for (int i = 0; i < uu.size(); i++) {--%>
    <%--out.println("Productname:"+uu.get(i).getProductname()+"<br/>");--%>
              <%--out.println("Producttype:"+uu.get(i).getProducttype()+"<br/>");--%>
                <%--out.println("Reviewrating:"+uu.get(i).getReviewrating()+"<br/>");--%>
               <%--out.println("Reviewdate:"+uu.get(i).getReviewdate()+"<br/>");--%>
                <%--out.println("Reviewtext:"+uu.get(i).getReviewtext()+"<br/>");--%>
               <%--out.println("Zipcode:"+uu.get(i).getZipcode()+"<br/>");}--%>
<%--%>--%>

    Productname:Iphone<%=r.getProductname()%><br>
    Producttype:phone<%=r.getProducttype()%><br>
    Reviewrating:4<%=r.getReviewrating()%><br>
    Reviewdate:11/02/2016<%=r.getReviewdate()%><br>
    Reviewtext:sssss<%=r.getReviewtext()%><br>
    Zipcode:60616<%=r.getZipcode()%><br>

</body>
</html>
