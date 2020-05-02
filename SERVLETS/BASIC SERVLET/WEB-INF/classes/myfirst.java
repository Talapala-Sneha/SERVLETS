import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class myfirst extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
res.setContentType("text/html");
String str = req.getParameter("name");
PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body>");
pw.println("<p>Musharraf</p>");
pw.println("<p>"+str+"</p>");
pw.println("</body>");
pw.println("</html>");
}
}
