package skill.share.project.skillshare;
import skill.share.project.skillshare.dl.*;
//import com.thinking.machines.hr.beans.*;

//for file operation on servlet
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;



import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class AddThread extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
//RequestDispatcher rd=request.getRequestDispatcher("/homePage.jsp");
HttpSession session=request.getSession();
try
{
//get the file chosen by the user
String imagePath="";
Part filePart = request.getPart("imageFile");	
if(filePart!=null)
{	
if(filePart.getSubmittedFileName().equals(""))
{
//do nothing 
//set imagePath of TreadDTO to null
System.out.println("nothing is came");
}
else
{
//save the image at server and assign that path to 
//imagePath of threadDTO
//get the InputStream to store the file somewhere
 InputStream fileInputStream = filePart.getInputStream();
File fileToSave = new File( "C:/tomcat9/webapps/skillshare/images/abc"+"/arun/"+filePart.getSubmittedFileName());
fileToSave.getParentFile().mkdirs();
Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
imagePath="C:/tomcat9/webapps/skillshare/images/abc"+"/arun/"+filePart.getSubmittedFileName();
}
}
try
{
ThreadDTOInterface  thread=new ThreadDTO();
if(request.getParameter("question")==null)
{
thread.setHeading(request.getParameter("heading"));
thread.setContent(request.getParameter("content"));
thread.setLink(request.getParameter("link"));
thread.setImagePath(imagePath);
thread.setType("article");
}
else
{
thread.setHeading("");
thread.setLink("");
thread.setImagePath("");
thread.setType("question");
}
thread.setSubject(request.getParameter("topic"));
thread.setContent(request.getParameter("question"));
int uId=(int)session.getAttribute("userId");
thread.setUserId(uId);

ThreadDAOInterface threadDAO=new ThreadDAO();
System.out.println("threadDTO contains : "+thread.getUserId()+thread.getContent());
threadDAO.add(thread);
}catch(DAOException daoException)
{
System.out.println("DAOException   "+daoException );
}
response.sendRedirect("/skillshare/homePage.jsp");
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
}