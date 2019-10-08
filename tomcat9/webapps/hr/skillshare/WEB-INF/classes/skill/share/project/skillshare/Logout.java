package skill.share.project.skillshare;
import skill.share.project.skillshare.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Logout extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{ 
try
{			              
            HttpSession session=request.getSession();  
            session.invalidate();    
			response.sendRedirect("homePage.jsp");
}
catch(Exception exception)
{
System.out.println(exception);
}
}
}
