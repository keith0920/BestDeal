
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.*;
import java.util.*;
import entity.*;

public class DBUtil {

    Connection conn = null;
    public void getConnection() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
            System.out.println("*****************sss********");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public  void insertUser(String userid,String password,String password2){
        try{
            String insertUser;
            Statement st = conn.createStatement();
            String sql = "INSERT INTO registration (username,pass,pass2)VALUES('"+userid+"','"+password+"','"+password2+"')";
            System.out.println(sql);
            st.execute(sql);
            System.out.println("--------------iiiii-----");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public  HashMap selectUser(){
        HashMap<String, User> map = new HashMap<String, User>();
        Statement st = null;
        String query = "SELECT * FROM registration;";

        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String userid= rs.getString("username");
                String password= rs.getString("pass");
                User user =new User(userid,password);
                map.put(userid,user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void insertOrder(String mingzi, String orderid, double price, String first, String last, String address)
    {
        try {
            String inserOrder;
            Statement st = conn.createStatement();
            String sql = "INSERT INTO customerOrder (mingzi,orderid,price,first,last,address)VALUES('"+mingzi+"','"+orderid+"','"+price+"','"+first+"','"+last+"','"+address+"')";
            System.out.println(sql);
            st.execute(sql);
            System.out.println("////////////OOOO/////");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public  HashMap selectOrder(){
        HashMap<String, Order> map = new HashMap<String, Order>();
        Statement st = null;
        String query = "SELECT * FROM customerOrder;";

        try {
            st = conn.createStatement();
            ResultSet u = st.executeQuery(query);
            while (u.next()) {
                String username= u.getString("mingzi");
                String orderid= u.getString("orderid");
                Double price = u.getDouble("price");
                String firstName= u.getString("first");
                String lastName= u.getString("last");
                String address= u.getString("address");
                Order order =new Order(username,orderid,price,firstName,lastName,address);
                map.put(username,order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;

    }
    public static void main(String args[]){
        DBUtil u =new DBUtil();

        u.getConnection();
        //u.insertOrder("qqq","12555",10,"qw","wq","2000");
       // SecureRandom random = new SecureRandom();
        //String id= new BigInteger(60, random).toString(32);
        Order uu = new Order();
        uu= (Order) u.selectOrder().get("12");
        System.out.println(uu.getAddress());




    }


}




