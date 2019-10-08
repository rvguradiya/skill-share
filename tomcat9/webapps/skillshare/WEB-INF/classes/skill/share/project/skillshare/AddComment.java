package skill.share.project.skillshare;
import skill.share.project.skillshare.dl.*;
//import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class AddComment extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{ try
{
BufferedReader br=request.getReader();
String line;
String jsonString="";
while(true)
{ line=br.readLine();
if(line==null) break;
jsonString+=line;
}
System.out.println("Raw string : "+jsonString);
response.setContentType("application/json");
PrintWriter pw=response.getWriter();
Gson gson=new Gson();
ApplicationResponse applicationResponse=new ApplicationResponse();
try
{
CommentDTOInterface comment=gson.fromJson(jsonString,CommentDTO.class);
CommentDAOInterface commentDAO=new CommentDAO();

//System.out.println(comment.getTime());
commentDAO.add(comment);
//we get generated keys in comment pointr point to object of comment
applicationResponse.result=comment;

}catch(DAOException daoException)
{ 
System.out.println("daoexception");
} catch(Exception exception)
{ 
System.out.println(exception);
}
jsonString=gson.toJson(applicationResponse);
pw.print(jsonString);
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}}}