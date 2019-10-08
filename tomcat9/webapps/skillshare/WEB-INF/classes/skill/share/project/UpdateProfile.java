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
public class UpdateProfile extends HttpServlet
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
//imagePath of userProfileDTO
//get the InputStream to store the file somewhere
 InputStream fileInputStream = filePart.getInputStream();
File fileToSave = new File( "C:/tomcat9/webapps/skillshare/images/"+filePart.getSubmittedFileName());
fileToSave.getParentFile().mkdirs();
Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
imagePath=filePart.getSubmittedFileName();
}
}
try
{
UserProfileDTOInterface  userProfile=new UserProfileDTO();
userProfile.setHeading(request.getParameter("heading"));
userProfile.setContent(request.getParameter("content"));
userProfile.setLink(request.getParameter("link"));
userProfile.setImagePath(imagePath);
userProfile.setType("article");
userProfile.setSubject(request.getParameter("topic"));

int uId=(int)session.getAttribute("userId");
userProfile.setUserId(uId);

UserProfileDAOInterface userProfileDAO=new UserProfileDAO();
System.out.println("userProfileDTO contains : "+userProfile.getUserId()+userProfile.getContent());
userProfileDAO.add(userProfile);
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