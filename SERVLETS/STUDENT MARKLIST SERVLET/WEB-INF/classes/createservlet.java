import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class createservlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String table=req.getParameter("t8");
String url="jdbc:mysql://localhost:3306/test";
String user="root";
String pass="sneha2000";
try
{
Connection con=DriverManager.getConnection(url,user,pass); 
Statement stmt;
if(table.equals("student"))
{
PreparedStatement ps=con.prepareStatement("insert into student values(?,?);");
ps.setString(1,req.getParameter("t1"));
ps.setString(2,req.getParameter("t2"));
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
}

if(table.equals("marks"))
{
PreparedStatement ps=con.prepareStatement("insert into marks values(?,?,?,?,?,?,?);");
ps.setString(1,req.getParameter("t1"));
ps.setString(2,req.getParameter("t2"));
ps.setString(3,req.getParameter("t3"));
ps.setString(4,req.getParameter("t4"));
ps.setString(5,req.getParameter("t5"));
ps.setString(6,req.getParameter("t6"));
ps.setString(7,req.getParameter("t7"));
ps.executeUpdate();

stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from marks");
pw.println("<html>");  
pw.println("<body>");  
pw.println("<table border=1 cellspacing=5 cellpadding=5>");
while(rs.next())
  {
  pw.println("<tr><td>"+rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"</td></tr>");
}
pw.println("</table>");    
pw.println("</body>");    
pw.println("</html>");
}

if(table.equals("mapping"))
{
PreparedStatement ps=con.prepareStatement("insert into mapping values(?,?);");
ps.setString(1,req.getParameter("t1"));
ps.setString(2,req.getParameter("t2"));
ps.executeUpdate();
stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from mapping");
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

}  
con.close();  
}
catch(Exception e)
{
 System.out.println(e);
}
}
}
