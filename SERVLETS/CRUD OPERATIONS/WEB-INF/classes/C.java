import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class C extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String url="jdbc:mysql://localhost:3306/test";
String user="root";
String pass="ssn";
try
{
Connection con=DriverManager.getConnection(url,user,pass); 
Statement stmt;
PreparedStatement ps=con.prepareStatement("insert into student values(?,?);");
ps.setString(1,req.getParameter("id1"));
ps.setString(2,req.getParameter("name1"));
ps.executeUpdate();
stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from student");
pw.println("<html>");  
pw.println("<body>");  
pw.println("<table border=1 cellspacing=5 cellpadding=5>");
while(rs.next())
  {
  pw.println("<tr><td>"+rs.getString(1)+"  "+rs.getString(2)+"</td></tr>");
}
pw.println("</table>");    
pw.println("</body>");    
pw.println("</html>");  
con.close();  
}
catch(Exception e)
{
 System.out.println(e);
}
}
}
