package skill.share.project.skillshare;
import skill.share.project.skillshare.dl.*;
//import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;

public class GetThreads extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{ 
try
{
response.setContentType("application/json");
ArrayList<ThreadDTOInterface> threads=new ThreadDAO().getThreads();
//ThreadDTOInterface t=new ThreadDetailsDAO().getThreadDetails(103);
//the above line is for testing the ThreadDetailsDAO's getThreadDetailsMethod
//Collections.sort(threads);
ApplicationResponse applicationResponse;
applicationResponse=new ApplicationResponse();
applicationResponse.result=threads;
Gson gson=new Gson();
String jsonString=gson.toJson(applicationResponse);
PrintWriter pw=response.getWriter();
pw.print(jsonString);
}catch(DAOException daoException)
{

System.out.println("dao"+daoException); //remove after testing
} catch(Exception exception)
{
System.out.println("dao"+exception); // remove after testing
}
}
}