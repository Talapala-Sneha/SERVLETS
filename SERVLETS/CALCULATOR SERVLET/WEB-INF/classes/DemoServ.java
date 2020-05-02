import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DemoServ extends HttpServlet

{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String num1=req.getParameter("anum1");
	String num2=req.getParameter("anum2");
	int sum,diff;
	int anum1=Integer.parseInt(num1);
	int anum2=Integer.parseInt(num2);
	sum=anum1+anum2;
	pw.println("Number 1:"+anum1);
	pw.println("\nNumber 2:"+anum2);
	pw.println("\nSum of "+anum1+"and "+anum2+"is "+sum);

}

}
