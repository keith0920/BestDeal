

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import entity.*;

public class OrderHistoryServlet extends HttpServlet {

//    protected Map users = new HashMap();
//    /**
//     * Initializes the servlet with some usernames/password
//     */
//
//
//    public void init() {
//        users.put("ma", "ma");
//    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        HttpSession sees =request.getSession(true);
        java.io.PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String filePath = request.getSession().getServletContext().getRealPath("orders");


//        Map<String,String> users = new HashMap<String,String>();
//        users.put((String) sees.getAttribute("uid"),(String) sees.getAttribute("pwd"));

        HashMap<String,Order> orders = new HashMap<String, Order>();
        DBUtil u =new DBUtil();
        u.getConnection();

        orders=u.selectOrder();
        System.out.println("**************************"+orders.size());



        String userid = (String) sees.getAttribute("minzi");



        //String password = String.valueOf(user.get(userid));
        if(userid!=null) {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Order history</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Here is your order:</h2>");
            out.println("<h2>"+orders.get(userid).getOrderid()+"</h2>");

            out.println("<h2>"+orders.get(userid).getMingzi()+"</h2>");
                out.println("<h2>"+orders.get(userid).getPrice()+"</h2>");
            out.println("<h2>"+orders.get(userid).getAddress()+"</h2>");
            out.println("<h2>"+orders.get(userid).getFirst()+"</h2>");
            out.println("<h2>"+orders.get(userid).getLast()+"</h2>");




            out.println("<a href='index.html'>go back</a>");
                out.println("</body>");
                out.println("</html>");
                out.close();
            }else {


            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Servlet Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Please log in first</h2>");
            out.println("<a href='index.html'>go back</a>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }



                //showPage(response, "Login Success!");



    }



    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}
