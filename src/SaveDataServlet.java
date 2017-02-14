import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import entity.*;




public class SaveDataServlet extends HttpServlet {

    protected Map users = new HashMap();

    public void init() {
        users.put("xxx", "xxx");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
//


        // PrintWriter out = response.getWriter();

        HttpSession s = request.getSession(true);
        double price = (double) s.getAttribute("price");

        String mingzi = (String) s.getAttribute("minzi");
        //String id = (String )s.getAttribute("id");
        SecureRandom random = new SecureRandom();
        String id = new BigInteger(60, random).toString(32);


        System.out.println(id);
        System.out.println("****************************");
        String first = (String) request.getParameter("firstName");
        String last = (String) request.getParameter("lastName");
        String address = (String) request.getParameter("address");
        String cardNum = (String) request.getParameter("cardNum");
        if (mingzi != null) {
            response.setContentType("text/html;charset=utf-8");

            try {
//                response.sendRedirect("saveOrder.jsp");
                Order o = new Order(mingzi, id, price, first, last, address);
                request.setAttribute("o",o);
                request.getRequestDispatcher("saveOrder.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            try {
                response.sendRedirect("login_first.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Order o = new Order(mingzi, id, price, first, last, address);
        DBUtil u = new DBUtil();
        u.getConnection();
        u.insertOrder(mingzi, id, price, first, last, address);
        try {
//            response.sendRedirect("saveOrder.jsp");
            request.setAttribute("o",o);
            request.getRequestDispatcher("saveOrder.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
