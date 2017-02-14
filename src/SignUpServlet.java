import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SignUpServlet extends HttpServlet {

    protected Map users = new HashMap();

    public void init() {
        users.put("xxx", "xxx");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    public static void processRequest(HttpServletRequest request, HttpServletResponse response)
    {


        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String name = "";
        System.out.println("******");


        UserRegister ur = new UserRegister();





        if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        }else{
            try {
                response.sendRedirect("register_error.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(password != null && password.length() != 0 &&password.equals(password2)) {
            password = password.trim();
        }else{
            try {
                response.sendRedirect("register_error.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

//            showPage(response, "Sign-up Failure! Invaild Password");
        }
        //HttpSession session = request.getSession(true);
        //session.setAttribute("username",userid);
        DBUtil u =new DBUtil();
        u.getConnection();
        u.insertUser(userid,password,password2);

        try{
            response.sendRedirect("register.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
