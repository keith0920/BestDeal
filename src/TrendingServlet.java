
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.http.*;
import entity.*;


public class TrendingServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        HttpSession sees =request.getSession(true);
        String productName = (String) sees.getAttribute("name");

        java.io.PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String filePath = request.getSession().getServletContext().getRealPath("reviews");

        HashMap<String, ArrayList<Review>> Review = new HashMap<>();
        MongoDBUtil u =new MongoDBUtil();
        u.getConnection();

        Review=u.selectReview();
        try {
            response.sendRedirect("Trending.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }


     //   if(productName!=null) {

//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Review Analisis</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h2>top zipcode:</h2>");
      /*  List<Document> pipeline = new ArrayList<Document>();
        Document group = new Document();
        group.put("$group", new Document("_id", "$zipcode").append("total", new Document("$sum", "$amount")));
        pipeline.add(group);

        Document sort = new Document("$sort",new Document("total",1));
        pipeline.add(sort);

        String output = "_group_";
        Document out = new Document("$out",output);
        pipeline.add(out);
        source.aggregate(pipeline)
                .allowDiskUse(true);
        MongoCollection<Document> result = db.getCollection(output);
        MongoCursor<Document> cursor = result.find().batchSize(100).iterator();
        while (cursor.hasNext()) {
            Document item = cursor.next();
            System.out.println(item.toJson());
        }
        cursor.close(); */

//        out.println("<h2>most liked:</h2>");
//
//        out.println("<h2>most popular:</h2>");
//





  /*          HashMap map = u.selectReview();
            ArrayList<Review> uu = (ArrayList<Review>) map.get(productName);
            for (int i = 0; i < uu.size(); i++) {

                out.println("Productname:"+uu.get(i).getProductname()+"<br/>");
                out.println("Producttype:"+uu.get(i).getProducttype()+"<br/>");
                out.println("Reviewrating:"+uu.get(i).getReviewrating()+"<br/>");
                out.println("Reviewadte:"+uu.get(i).getReviewdate()+"<br/>");
                out.println("Reviewtext:"+uu.get(i).getReviewtext()+"<br/>");
                out.println("Zipcode:"+uu.get(i).getZipcode()+"<br/>");

            } */
        }

  //  }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}