
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
import org.apache.catalina.connector.Request;
import java.util.List;


public class ShowReviewServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             {

        HttpSession sees =request.getSession(true);
        String productName = (String) sees.getAttribute("name");

//                 PrintWriter out = null;
//                 try {
//                     out = response.getWriter();
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//                 response.setContentType("text/html");
////        String filePath = request.getSession().getServletContext().getRealPath("reviews");
//
//        HashMap<String, ArrayList<Review>> Review = new HashMap<>();
            MongoDBUtil u =new MongoDBUtil();
            u.getConnection();
        if(productName!=null) {

            HashMap map = u.selectReview();
            ArrayList<Review> uu = (ArrayList<Review>) map.get(productName);
            try {
                Review r= new Review();
                response.sendRedirect("showReview.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
//            for (int i = 0; i < uu.size(); i++) {
//
//                out.println("Productname:"+uu.get(i).getProductname()+"<br/>");
//                out.println("Producttype:"+uu.get(i).getProducttype()+"<br/>");
//                out.println("Reviewrating:"+uu.get(i).getReviewrating()+"<br/>");
//                out.println("Reviewdate:"+uu.get(i).getReviewdate()+"<br/>");
//                out.println("Reviewtext:"+uu.get(i).getReviewtext()+"<br/>");
//                out.println("Zipcode:"+uu.get(i).getZipcode()+"<br/>");
//
//            }
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
