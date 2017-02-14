
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import entity.*;

public class ReviewFormServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        HttpSession sees =request.getSession(true);
        java.io.PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        HashMap<String, ArrayList<Review>> Review = new HashMap<>();

        System.out.println("**************************"+Review.size());

        String productName = (String) request.getParameter("modelName");
        String userName = (String) request.getParameter("uid");
        String productType = (String) request.getParameter("category");
        String reviewRating = (String) request.getParameter("rating");
        String reviewDate = (String) request.getParameter("date");
        String reviewText = (String) request.getParameter("reviewText");
        String zipcode = (String) request.getParameter("retailerZip");
        System.out.println("_~~~~~~re~~~~~~_"+zipcode);


        MongoDBUtil o =new MongoDBUtil();
        o.getConnection();
        o.insertReview(productName,userName,productType,reviewRating,reviewDate,reviewText,zipcode);
        try {
            response.sendRedirect("reviewForm.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}

