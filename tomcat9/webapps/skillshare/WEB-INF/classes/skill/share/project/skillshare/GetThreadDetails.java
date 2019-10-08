package skill.share.project.skillshare;
import skill.share.project.skillshare.dl.*;
//import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class GetThreadDetails extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{ 
try
{
BufferedReader br=request.getReader();
String line;
String jsonString="";
while(true)
{ line=br.readLine();
if(line==null) break;
jsonString+=line;
}
//System.out.println("Raw string : "+jsonString);
response.setContentType("application/json");
PrintWriter pw=response.getWriter();
Gson gson=new Gson();
ThreadDetailsApplicationResponse applicationResponse=new ThreadDetailsApplicationResponse();
try
{
response.setContentType("application/json");
ThreadDetailsRequestDTO rq=gson.fromJson(jsonString,ThreadDetailsRequestDTO.class);
int threadId=rq.getThreadId();
ArrayList<ThreadCommentDetailsDTOInterface> threadComments=new ThreadCommentDetailsDAO().getThreadCommentDetails(threadId);
ThreadDetailsDTOInterface threadDetails=new ThreadDetailsDAO().getThreadDetails(threadId);
//we get generated keys in comment pointr point to object of comment
applicationResponse.thread=threadDetails;
applicationResponse.comments=threadComments;
jsonString=gson.toJson(applicationResponse);
pw.print(jsonString);

}catch(DAOException daoException)
{ 
System.out.println("daoexception");
}
}
 catch(Exception exception)
{ 
System.out.println(exception);
}
}
}