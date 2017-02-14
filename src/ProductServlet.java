import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ProductServlet extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String filePath = request.getSession().getServletContext().getRealPath("ProductCatalog.xml");


        XMLparse list = new XMLparse(filePath);
        PrintWriter out = response.getWriter();
        List<entity.Console> con = list.consoles;
        HttpSession sess = request.getSession(true);


        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet Result</title>");
        out.println("</head>");
        out.println("<body>");
        for(int i=0;i<con.size();i++){
            out.println("<h2>" + con.get(i).getId() + "</h2>");
            out.println("<h2>" + con.get(i).getName() + "</h2>");
            out.println("<h2>" + con.get(i).getPrice() + "</h2>");
            out.println("<div>");

//            sess.setAttribute("id",con.get(i).getId());




            out.println("</div>");



        }
        out.println("<a href='index.html'>Home</a>");

        out.println("</body>");
        out.println("</html>");
        out.close();


       // showPage(response,con.toString());








    }


//    protected void showPage(HttpServletResponse response, String message) throws ServletException, java.io.IOException {
//        response.setContentType("text/html");
//        java.io.PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Login Servlet Result</title>");
//        out.println("</head>");
//        out.println("<body>");
//
//        out.println("<h2>" + message + "</h2>");
//
//        out.println("</body>");
//        out.println("</html>");
//        out.close();
//
//
//    }
}
