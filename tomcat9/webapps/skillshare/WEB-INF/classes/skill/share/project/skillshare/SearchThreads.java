package skill.share.project.skillshare;
import skill.share.project.skillshare.dl.*;
//import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;

public class SearchThreads extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{ 
}
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
Gson gson=new Gson();

SearchRequestDTO rq=gson.fromJson(jsonString,SearchRequestDTO.class);

String searchString=rq.getSearchString();
System.out.println("string is "+searchString);


response.setContentType("application/json");
ArrayList<ThreadDTOInterface> threads=new ThreadDAO().searchThreads(searchString);
ApplicationResponse applicationResponse;
applicationResponse=new ApplicationResponse();
applicationResponse.result=threads;
jsonString=gson.toJson(applicationResponse);
PrintWriter pw=response.getWriter();
pw.print(jsonString);
}catch(DAOException daoException)
{

System.out.println("dao e "+daoException); //remove after testing
} catch(Exception exception)
{
System.out.println("e   "+exception); // remove after testing
}
}
}