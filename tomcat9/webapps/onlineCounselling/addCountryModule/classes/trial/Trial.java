
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class Trial extends HttpServlet
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
try
{
response.setContentType("application/json");
ApplicationResponse rq=gson.fromJson(jsonString,ApplicationResponse.class);
System.out.println(rq.getABC());
ArrayList<ADTO> e=(ArrayList<ADTO>)rq.getObj();
//json array ko corrosponding dto ki arraylist me convert kiya me convert kiya.....
System.out.println(e.size());
System.out.println(e);
int count=e.size();
   while (count > 0) {
ADTO a=e.get(count-1);
	 System.out.println(a.getId()+"   "+a.getName()+" " +a.getCode()+" "+a.getCity() );
count--;
}
//int threadId=rq.getThreadId();
//ArrayList<ThreadCommentDetailsDTOInterface> threadComments=new ThreadCommentDetailsDAO().getThreadCommentDetails(threadId);
//ThreadDetailsDTOInterface threadDetails=new ThreadDetailsDAO().getThreadDetails(threadId);
//we get generated keys in comment pointr point to object of comment
//applicationResponse.thread=threadDetails;
//applicationResponse.comments=threadComments;
//jsonString=gson.toJson(applicationResponse);
//pw.print(jsonString);

}
 catch(Exception exception)
{ 
System.out.println(exception);
}

} catch(Exception exception)
{ 
System.out.println(exception);
}
}
}