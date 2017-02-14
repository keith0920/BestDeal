import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ListServlet extends HttpServlet {

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
//        for(int i=0;i<con.size();i++){
//            out.println("<h2>" + con.get(i).getId() + "</h2>");
//            out.println("<h2>" + con.get(i).getName() + "</h2>");
//            out.println("<h2>" + con.get(i).getPrice() + "</h2>");
//
//
//
//        }



        //showPage(response,con.toString());

        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet Result</title>");
        out.println("</head>");
        out.println("<body>");

        String CategoryName = request.getParameter("category");
        HttpSession sess = request.getSession(true);


        if(CategoryName.equals("Phone")){
            sess.setAttribute("id",con.get(0).getId());
            sess.setAttribute("price",con.get(0).getPrice());
            sess.setAttribute("name",con.get(0).getName());
            System.out.println(sess.getAttribute("name"));

            out.println("<h2>" + con.get(0).getId() + "</h2>");
            out.println("<h2>" + con.get(0).getName() + "</h2>");
            out.println("<h2>" + con.get(0).getPrice() + "</h2>");
            out.println("<div><form><a href='GetForm.htm'>Buy</a></form></div>");
            out.println("<div><form><a href='reviewForm.html'>review</a></form></div>");
            out.println("<div><form><a href='/ShowReviewServlet'>show review</a></form></div>");


        }else if(CategoryName.equals("Tablets")){
            out.println("<h2>" + con.get(1).getId() + "</h2>");
            out.println("<h2>" + con.get(1).getName() + "</h2>");
            out.println("<h2>" + con.get(1).getPrice() + "</h2>");
            out.println("<div><form><a href='GetForm.htm'>Buy</a></form></div>");
            out.println("<div><form><a href='reviewForm.html'>review</a></form></div>");
            out.println("<div><form><a href='/ShowReviewServlet'>show review</a></form></div>");
            sess.setAttribute("id",con.get(1).getId());
            sess.setAttribute("price",con.get(1).getPrice());

        }else if(CategoryName.equals("Laptop")){
            out.println("<h2>" + con.get(2).getId() + "</h2>");
            out.println("<h2>" + con.get(2).getName() + "</h2>");
            out.println("<h2>" + con.get(2).getPrice() + "</h2>");
            out.println("<div><form><a href='GetForm.htm'>Buy</a></form></div>");
            out.println("<div><form><a href='reviewForm.html'>review</a></form></div>");
            out.println("<div><form><a href='/ShowReviewServlet'>show review</a></form></div>");
            sess.setAttribute("id",con.get(2).getId());
            sess.setAttribute("price",con.get(2).getPrice());

        }else{
            out.println("<h2>" + con.get(3).getId() + "</h2>");
            out.println("<h2>" + con.get(3).getName() + "</h2>");
            out.println("<h2>" + con.get(3).getPrice() + "</h2>");
            out.println("<div><form><a href='GetForm.htm'>Buy</a></form></div>");
            out.println("<div><form><a href='reviewForm.html'>review</a></form></div>");
            out.println("<div><form><a href='/ShowReviewServlet'>show review</a></form></div>");
            sess.setAttribute("id",con.get(3).getId());
            sess.setAttribute("price",con.get(3).getPrice());

        }










        out.println("</body>");
        out.println("</html>");
        out.close();







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
