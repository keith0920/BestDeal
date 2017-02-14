import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDataStoreUtilities
{

public static Connection getConnection()
{
	Connection conn = null;
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn= 
DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdealdatabase","root","root");
}
catch(Exception e)
{
	e.printStackTrace();

}

return conn;
}

public static void close(Connection con){
	try{
		con.close();
	}catch(SQLException e){
		;
	}
	
}
}