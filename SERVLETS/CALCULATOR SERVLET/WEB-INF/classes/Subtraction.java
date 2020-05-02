import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class Subtraction extends HttpServlet

{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	int sum,diff;
	String num3=req.getParameter("snum1");
	String num4=req.getParameter("snum2");
	int snum1=Integer.parseInt(num3);
	int snum2=Integer.parseInt(num4);
	diff=snum1-snum2;
	pw.println("Number 1:"+snum1);
	pw.println("\nNumber 2:"+snum2);
	pw.println("\nDifference of "+snum1+"and "+snum2+"is "+diff);
}
}
