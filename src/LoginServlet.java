/*
 * LoginServlet.java
 *
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import entity.*;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           /* throws ServletException, java.io.IOException */{

        HttpSession sees =request.getSession(true);
        //java.io.PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String filePath = request.getSession().getServletContext().getRealPath("signup");

        DBUtil u =new DBUtil();

        u.getConnection();
        HashMap<String,User> user =u.selectUser();


        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        String realpassword="";

        realpassword = String.valueOf(user.get((String) userid).getPwd());
        System.out.println("******"+userid);

        System.out.println("******"+realpassword);


        //String password = String.valueOf(user.get(userid));
        if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        }
        if(password != null && password.length() != 0) {
            password = password.trim();
        }
        if(userid != null && password != null) {
            String rr="";
            try{
                realpassword = String.valueOf(user.get((String) userid).getPwd());
                System.out.println("******"+userid);

                System.out.println("******"+realpassword);
            }catch (Exception e){
                e.printStackTrace();
            }

            }


            System.out.println(realpassword);
            if(realpassword != null && realpassword.equals(password)) {

                //showPage(response, "Login Success!");
                try{
                    response.sendRedirect("login.jsp");
                }catch (Exception e){
                    e.printStackTrace();
                }
                sees.setAttribute("minzi",userid);


            } else {
            //showPage(response, "Login Failure!  You must supply a username and password");
                try {
                    response.sendRedirect("login_error.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        DBUtil ui =new DBUtil();
        ui.getConnection();
        ui.selectUser();

        try{
            response.sendRedirect("login.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
