import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class DBServ extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String url="jdbc:mysql://localhost:3306/test";
String user="root";
String pass="ssn";
try
{
Connection con=DriverManager.getConnection(url,user,pass); 
Statement stmt;
pw.println("Contents of database:"); 
stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from student");  
while(rs.next())  
  pw.println(rs.getString(1)+"  "+rs.getString(2));  
con.close();  
}
catch(Exception e)
{
 System.out.println(e);
}
}
}
