import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class markgenerateservlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String table=req.getParameter("rno");
String url="jdbc:mysql://localhost:3306/test";
String user="root";
String pass="sneha2000";
try
{
Connection con=DriverManager.getConnection(url,user,pass); 
Statement stmt;
stmt=con.createStatement(); 
pw.println("<html>");  
pw.println("<body>"); 
int m[]=new int[25];
int i=0,found=0;
ResultSet rs=stmt.executeQuery("select s.name,s.regno,m.CS2351,m.CS2352,m.CS2353,m.CS2354,m.CS2355,m.CS2356 from student s,marks m  where s.regno=m.regno;");
while(rs.next())
{
	if(rs.getString(2).equals(table))
    {     found=1;
          pw.println("<p>Register no:"+rs.getString(2)+"                                 "+"Name:"+rs.getString(1)+"</p>"); 
          m[0]=Integer.parseInt(rs.getString(3));
		  m[1]=Integer.parseInt(rs.getString(4));
		  m[2]=Integer.parseInt(rs.getString(5));
		  m[3]=Integer.parseInt(rs.getString(6));
		  m[4]=Integer.parseInt(rs.getString(7));
	      m[5]=Integer.parseInt(rs.getString(8));}
}
if(found==0)
	req.getRequestDispatcher("error.jsp").forward(req,res);
ResultSet rs1=stmt.executeQuery("select * from mapping;");
pw.println("<table border=1 cellspacing=5 cellpadding=5>");
pw.println("<tr><th>Subcode</th><th>Subject name</th><th>Marks</th></tr>");
while(rs1.next())
{
  pw.println("<tr><td>"+rs1.getString(1)+"</td><td>"+rs1.getString(2)+"</td><td>"+m[i++]+"</td></tr>");
}
pw.println("</table>");pw.println("</body>");    
pw.println("</html>");
con.close();  
}
catch(Exception e)
{
 System.out.println(e);
}
}
}